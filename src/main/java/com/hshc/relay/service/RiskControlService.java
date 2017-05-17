package com.hshc.relay.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.hshc.relay.dao.CustomerDao;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.qimencloud.api.DefaultQimenCloudClient;
import com.qimencloud.api.QimenCloudClient;
import com.qimencloud.api.sceneo67v8y8p21.request.HshcRiskControlCustomerReturnRequest;
import com.qimencloud.api.sceneo67v8y8p21.response.HshcRiskControlCustomerReturnResponse;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TmallCarLeaseRiskcallbackRequest;
import com.taobao.api.response.TmallCarLeaseRiskcallbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AuthorizedSessionService authorizedSessionService;
    @Autowired
    private CustomerDao customerDao;

    @Transactional(rollbackFor = Exception.class)
    public int add(final Customer customer){
        logger.debug("risk-control customer :" + JSON.toJSONString(customer));
        int rows = baseDao.insert(customer);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {

                QimenCloudClient cloudClient = new DefaultQimenCloudClient(getReturnUrl(), getAppKey(), getAppSecret());
                HshcRiskControlCustomerReturnRequest request = new HshcRiskControlCustomerReturnRequest();
                request.setConsigneeAddress(customer.getAddr());
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

    public TmallCarLeaseRiskcallbackResponse.Result sendRiskControlResult(String uuid) throws ApiException {
        Customer customer = new Customer();
        customer.setUuid(uuid);
        TmallCarLeaseRiskcallbackRequest.CreditInfoTopDto topDto = customerDao.selectTopDto(customer);
        Preconditions.checkNotNull(topDto, "no customer matches the given uuid " + uuid);
        topDto.setPass(true);

        TaobaoClient client = new DefaultTaobaoClient(getTopApi(), getAppKey(), getAppSecret());
        TmallCarLeaseRiskcallbackRequest req = new TmallCarLeaseRiskcallbackRequest();
        req.setCreditInfo(topDto);
        TmallCarLeaseRiskcallbackResponse.Result result = client.execute(req, authorizedSessionService.getAuthorizedSession("sandbox_taobao1234").getAccessToken()).getResult();
        logger.info("risk control callback : request=" + JSON.toJSONString(topDto) + ", resposne=" + JSON.toJSONString(result));
        return result;
    }
}
