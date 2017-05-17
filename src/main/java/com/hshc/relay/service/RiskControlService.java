package com.hshc.relay.service;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.qimencloud.api.DefaultQimenCloudClient;
import com.qimencloud.api.QimenCloudClient;
import com.qimencloud.api.sceneo67v8y8p21.request.HshcRiskControlCustomerReturnRequest;
import com.qimencloud.api.sceneo67v8y8p21.response.HshcRiskControlCustomerReturnResponse;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:54
 */
@Service
public class RiskControlService extends BaseService<Customer> {

    @Transactional(rollbackFor = Exception.class)
    public int add(final Customer customer){
        logger.debug("risk-control customer :" + JSON.toJSONString(customer));
        int rows = baseDao.insert(customer);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {

                QimenCloudClient cloudClient = new DefaultQimenCloudClient(getReturnUrl(), getAppKey(), getAppSecret());
                HshcRiskControlCustomerReturnRequest request = new HshcRiskControlCustomerReturnRequest();
                request.setConsigneeAddress(customer.getConsigneeAddress());
                request.setIdentityNo(customer.getIdentityNo());
                request.setMobile(customer.getMobile());
                request.setName(customer.getName());
//                request.setItemId(customer.getItemId());
                request.setTargetAppKey(getAppKey());

                try {
                    HshcRiskControlCustomerReturnResponse response = cloudClient.execute(request);
                    if(response.getSuccess() != null && response.getSuccess()){
                        customer.setReturned(true);
                        modify(customer);
                    }
                } catch (ApiException e) {
                    logger.error("", e);
                }
            }
        });

        return rows;

    }


}
