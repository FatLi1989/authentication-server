package novli.auth.authentication.browser.controller;

import lombok.extern.slf4j.Slf4j;
import novli.auth.authentication.browser.support.SimpleResponse;
import novli.auth.authentication.core.SecurityProperties;
import novli.auth.authentication.core.validate.ValidateCodeProcessor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author novLi
 * @date 2019年08月20日 15:40
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    @Autowired
    private SecurityProperties securityProperties;

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @GetMapping("/code/{type}")
    public void validateImgCode(HttpServletRequest request, HttpServletResponse response, @PathVariable("type") String type) throws Exception {
        //根据不同类型调用验证码处理方式
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor validateCodeProcessor = validateCodeProcessors.get(name);
        validateCodeProcessor.generate(new ServletWebRequest(request, response));
    }

    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }

        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }

}
