package novli.auth.authentication.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author novLi
 * @date 2019年08月29日 09:37
 */
public class BrowserSessionInformationExpiredStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    /**
     * 构造函数传递失效跳转地址
     *
     * @param invalidSessionUrl
     */
    public BrowserSessionInformationExpiredStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

    }
}
