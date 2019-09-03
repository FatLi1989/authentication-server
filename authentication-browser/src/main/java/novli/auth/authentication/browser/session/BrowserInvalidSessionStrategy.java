package novli.auth.authentication.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * session无效处理
 *
 * @author novLi
 * @date 2019年08月29日 09:32
 */
public class BrowserInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {


    /**
     * 构造函数传递失效跳转地址
     *
     * @param invalidSessionUrl
     */
    public BrowserInvalidSessionStrategy(String invalidSessionUrl) {
        super(invalidSessionUrl);
    }
    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
}
