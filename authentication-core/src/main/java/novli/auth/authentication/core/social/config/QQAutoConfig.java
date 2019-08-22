package novli.auth.authentication.core.social.config;

import novli.auth.authentication.core.SecurityProperties;
import novli.auth.authentication.core.properties.QQProperties;
import novli.auth.authentication.core.social.connet.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * qq 连接工厂配置
 *
 * @author NovLi
 * @date 2019/8/22
 **/
@Configuration
//配置信息里有此属性才实例化
@ConditionalOnProperty(prefix = "novli.nacos.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqProperties = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqProperties.getQqProviderId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }
}
