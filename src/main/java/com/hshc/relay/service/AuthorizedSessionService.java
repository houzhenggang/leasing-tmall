package com.hshc.relay.service;

import com.hshc.relay.entity.AuthorizedSession;
import com.hshc.relay.exception.NoAuthorizedSessionAcquiredException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-06 16:33
 */
@Service
public class AuthorizedSessionService extends BaseService<AuthorizedSession> {

    @Value("${top.appKey}")
    private String appKey;

    @Value("${top.appSecret}")
    private String appSecret;

    @Value("${top.sandboxAppKey}")
    private String sandboxAppKey;

    @Value("${top.sandboxAppKey}")
    private String sandboxAppSecret;

    @Value("${qimen.redirectUri}")
    private String redirectUri;

    @Value("${qimen.authUrl}")
    private String authUrl;

    @Value("${qimen.tokenUrl}")
    private String tokenUrl;

    public AuthorizedSession getAuthorizedSession(String taobaoUserNick){
        AuthorizedSession queryAuthorizedSession = new AuthorizedSession();
        queryAuthorizedSession.setTaobaoUserNick(taobaoUserNick);
        AuthorizedSession authorizedSession = baseDao.selectOne(queryAuthorizedSession);
        if(authorizedSession == null){
            throw new NoAuthorizedSessionAcquiredException(authUrl + "?response_type=code&client_id=" + appKey
                    + "&redirect_uri=" + redirectUri + "/session-auth" + "&view=web");
        }
        return authorizedSession;
    }
    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getSandboxAppKey() {
        return sandboxAppKey;
    }

    public String getSandboxAppSecret() {
        return sandboxAppSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public String getAuthUrl() {
        return authUrl;
    }
}
