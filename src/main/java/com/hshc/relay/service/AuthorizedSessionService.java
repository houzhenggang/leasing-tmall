package com.hshc.relay.service;

import com.hshc.relay.entity.AuthorizedSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 16:33
 */
@Service
public class AuthorizedSessionService extends BaseService<AuthorizedSession> {

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.redirectUri}")
    private String redirectUri;

    @Value("${auth.authUrl}")
    private String authUrl;

    public AuthorizedSession getAuthorizedSession(String taobaoUserNick){
        AuthorizedSession authorizedSession = new AuthorizedSession();
        authorizedSession.setTaobaoUserNick(taobaoUserNick);
        return baseDao.selectOne(authorizedSession);
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getAuthUrl() {
        return authUrl;
    }
}
