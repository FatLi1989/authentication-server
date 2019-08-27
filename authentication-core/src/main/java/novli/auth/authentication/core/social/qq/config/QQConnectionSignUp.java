package novli.auth.authentication.core.social.qq.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author novLi
 * @date 2019年08月27日 11:01
 */
@Component
public class QQConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
