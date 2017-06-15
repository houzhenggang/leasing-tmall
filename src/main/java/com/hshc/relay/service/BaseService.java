package com.hshc.relay.service;

import com.hshc.relay.dao.BaseDao;
import com.hshc.relay.dto.Page;
import com.hshc.relay.dto.PageRequest;
import com.hshc.relay.interceptor.PageInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class BaseService<T, E>{

    protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected BaseDao<T, E> baseDao;

    @Value("${top.appKey}")
    private String appKey;

    @Value("${top.appSecret}")
    private String appSecret;

    @Value("${qimen.redirectUri}")
    private String redirectUri;

    @Value("${qimen.authUrl}")
    private String authUrl;

    @Value("${qimen.tokenUrl}")
    private String tokenUrl;

    /**
     * top接口地址
     */
    @Value("${top.httpsApi}")
    private String topApi;

    /**
     * 淘宝消息服务地址
     */
    @Value("${taobao.messageService}")
    private String messageServiceUrl;

    /**
     * 回传erp地址
     */
    @Value("${qimen.returnUrl}")
    private String returnUrl;

    @Value("${taobao.initMessageService}")
    private boolean initMessageService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public T getOne(E e){
        return baseDao.selectOne(e);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<T> getList(E e){
        return baseDao.selectList(e);
    }

    @Transactional(rollbackFor = Exception.class)
    public int add(T t){
        return baseDao.insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    public int batchAdd(List<T> tList){
        return baseDao.batchInsert(tList);
    }

    @Transactional(rollbackFor = Exception.class)
    public int modify(T t){
        return baseDao.update(t);
    }

    @Transactional(rollbackFor = Exception.class)
    public int remove(Integer id){
        return baseDao.delete(id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<E> getPage(PageRequest<E> pageRequest){
        PageInterceptor.init(pageRequest.getPageNum(), pageRequest.getPageSize());
        baseDao.selectList(pageRequest.getQueryObj());
        return PageInterceptor.getPage();
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getTopApi() {
        return topApi;
    }

    public String getMessageServiceUrl() {
        return messageServiceUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public boolean isInitMessageService() {
        return initMessageService;
    }
}
