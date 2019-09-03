package novli.auth.authentication.browser.config;

import novli.auth.authentication.browser.session.BrowserInvalidSessionStrategy;
import novli.auth.authentication.browser.session.BrowserSessionInformationExpiredStrategy;
import novli.auth.authentication.core.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**配置 session失效,超时策略
 * @author novLi
 * @date 2019年08月29日 09:39
 */
@Configuration
public class BrowserSecurityBeanConfig {

    @Autowired
    SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(value = InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new BrowserInvalidSessionStrategy("");
    }

    @Bean
    @ConditionalOnMissingBean(value = SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new BrowserSessionInformationExpiredStrategy("");
    }


}
