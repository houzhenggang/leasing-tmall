package com.hshc.relay.dto.qo;

import com.taobao.api.internal.tmc.Message;

import java.sql.Timestamp;

/**
 * @author 钟林俊
 * @version V1.0 2017-06-14 14:49
 */
public class MessageQo extends Message {

    private Timestamp pubTimeFrom;

    private Timestamp pubTimeTo;

    private Timestamp outgoingTimeFrom;

    private Timestamp outgoingTimeTo;

    public Timestamp getPubTimeFrom() {
        return pubTimeFrom;
    }

    public void setPubTimeFrom(Timestamp pubTimeFrom) {
        this.pubTimeFrom = pubTimeFrom;
    }

    public Timestamp getPubTimeTo() {
        return pubTimeTo;
    }

    public void setPubTimeTo(Timestamp pubTimeTo) {
        this.pubTimeTo = pubTimeTo;
    }

    public Timestamp getOutgoingTimeFrom() {
        return outgoingTimeFrom;
    }

    public void setOutgoingTimeFrom(Timestamp outgoingTimeFrom) {
        this.outgoingTimeFrom = outgoingTimeFrom;
    }

    public Timestamp getOutgoingTimeTo() {
        return outgoingTimeTo;
    }

    public void setOutgoingTimeTo(Timestamp outgoingTimeTo) {
        this.outgoingTimeTo = outgoingTimeTo;
    }
}
