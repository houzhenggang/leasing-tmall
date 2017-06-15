package com.hshc.relay.dao;

import com.taobao.api.request.ScitemMapAddRequest;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author 王华英
 * @version V1.0 2017-05-12 16:57
 */
@Repository
public interface ScitemMapAddRequestDao extends BaseDao<ScitemMapAddRequest, ScitemMapAddRequest> {
    int updateSendStatu(Map<String,String> param);
}
