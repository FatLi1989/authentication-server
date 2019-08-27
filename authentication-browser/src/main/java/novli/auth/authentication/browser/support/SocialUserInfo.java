package novli.auth.authentication.browser.support;

import lombok.Data;

@Data
public class SocialUserInfo  {

    /**
     * qq 微信 等第三方登录名称
     **/
    private String providerId;
    /**
     * qq 微信 等第三方登录openId
     **/
    private String providerUserId;
    /**
     * 昵称
     **/
    private String nickName;
    /**
     * 头像
     **/
    private String headImg;
}
