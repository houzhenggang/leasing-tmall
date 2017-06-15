package com.hshc.relay.dto.qo;

import com.hshc.relay.entity.riskcontrol.Customer;

import java.sql.Timestamp;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-14 14:05
 */
public class CustomerQo extends Customer{

    private Timestamp createTimeFrom;

    private Timestamp createTimeTo;

    public Timestamp getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(Timestamp createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public Timestamp getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(Timestamp createTimeTo) {
        this.createTimeTo = createTimeTo;
    }
}
