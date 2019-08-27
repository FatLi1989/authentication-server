package novli.auth.authentication.browser.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author novLi
 * @date 2019年08月27日 11:01
 */
@Component
public class BrowserConnectionSignUp implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        return connection.getDisplayName();
    }
}
