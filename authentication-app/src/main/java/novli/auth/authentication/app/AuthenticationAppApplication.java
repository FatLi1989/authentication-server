package novli.auth.authentication.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"novli.auth.authentication.app.*"})
public class AuthenticationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationAppApplication.class, args);
    }

}
