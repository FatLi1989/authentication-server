package novli.auth.authentication.core.social.qq.connet;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import novli.auth.authentication.core.social.qq.api.QQ;
import novli.auth.authentication.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

@Slf4j
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    @Setter
    @Getter
    private String appId;
    /**
     * 三方登录第一步导向认证服务器的url
     **/
    private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize";
    /**
     * 三方登录第四步获取令牌token的url
     **/
    private static final String ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";


    public QQServiceProvider(String appId, String appSecret) {
        super(new QQAuth2Template(appId, appSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
