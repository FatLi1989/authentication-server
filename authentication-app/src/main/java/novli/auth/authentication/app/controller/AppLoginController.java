package novli.auth.authentication.app.controller;

import novli.auth.authentication.core.support.SimpleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author novLi
 * @date 2019年09月05日 17:26
 */
@RestController
public class AppLoginController {


    @PostMapping("app/login")
    public SimpleResponse login() {

        return SimpleResponse.builder().data("登录成功").build();
    }


}
