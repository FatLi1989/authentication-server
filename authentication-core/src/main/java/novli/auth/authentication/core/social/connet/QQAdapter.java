package novli.auth.authentication.core.social.connet;

import novli.auth.authentication.core.social.qq.QQ;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * api适配器
 *
 * @author NovLi
 * @description //TODO
 * @date 2019/8/22
 **/


public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试服务是否可以使用
     *
     * @param api 自定义接口类型
     * @return boolean
     * @author NovLi
     * @date 2019/8/22
     **/
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * 设置连接参数
     *
     * @param api
     * @param values
     * @author NovLi
     * @description //TODO
     * @date 2019/8/22
     **/
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        values.setDisplayName(api.getInfo().getNickname());
        values.setImageUrl(api.getInfo().getFigureurl_qq_1());
        //个人主页地址
        values.setProfileUrl(null);
        //openId
        values.setProviderUserId(api.getInfo().getOpenId());
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }
    /** 更新个人主页状态
     * @author NovLi
     * @date 2019/8/22
     * @param api
     * @param message
     **/
    @Override
    public void updateStatus(QQ api, String message) {
        //do_nothing
    }
}
