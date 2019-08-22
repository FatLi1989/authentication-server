package novli.auth.authentication.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class BrowserProperties {

    @Setter
    @Getter
    private String loginPage;

    @Setter
    @Getter
    private int rememberMeSeconds;

    @Setter
    @Getter
    private String signUpUrl;

    public BrowserProperties() {
    }
}
