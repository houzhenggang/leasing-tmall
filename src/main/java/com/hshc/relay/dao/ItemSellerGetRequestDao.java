package com.hshc.relay.dao;

import com.taobao.api.request.ItemSellerGetRequest;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author 王华英
 * @version V1.0 2017-05-09 16:57
 */
@Repository
public interface ItemSellerGetRequestDao extends BaseDao<ItemSellerGetRequest, ItemSellerGetRequest>{
    int updateSendStatu(Map<String,String> param);
}
