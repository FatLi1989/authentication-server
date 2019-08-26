package novli.auth.authentication.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {


    /**
     * 获取openId,需要参数token
     */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 获取用户信息，需要openId和oauth_consumer_key
     */
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    @Setter
    @Getter
    private String appId;
    @Setter
    @Getter
    private String openId;

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 通过构造器发送http请求获取构造器
     *
     * @param accessToken
     * @author NovLi
     * @description //TODO
     * @date 2019/8/22
     **/
    public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        log.info("获取到openId -> 【{}】", result);
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    @Override
    public QQInfo getInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        log.info("获取到用户信息 -> 【{}】", result);
        try {
            QQInfo qqInfo = objectMapper.readValue(result, QQInfo.class);
            qqInfo.setOpenId(openId);
            return qqInfo;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("转换类型出现错误 -> 【{}】", result);
            return null;
        }
    }
}
