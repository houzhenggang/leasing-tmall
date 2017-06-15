package com.hshc.relay.dao;

import com.hshc.relay.dto.qo.CustomerQo;
import com.hshc.relay.entity.riskcontrol.Customer;
import com.taobao.api.request.TmallCarLeaseRiskcallbackRequest;
import org.springframework.stereotype.Repository;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-07 16:57
 */
@Repository
public interface CustomerDao extends BaseDao<Customer, CustomerQo> {

    TmallCarLeaseRiskcallbackRequest.CreditInfoTopDto selectTopDto(Customer customer);

}
