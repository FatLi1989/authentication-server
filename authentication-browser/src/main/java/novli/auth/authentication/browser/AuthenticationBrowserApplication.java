package novli.auth.authentication.browser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"novli.auth.authentication.core.*", "novli.auth.authentication.browser.*"})
public class AuthenticationBrowserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationBrowserApplication.class, args);
    }

}
