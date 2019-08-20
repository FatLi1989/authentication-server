package novli.auth.authentication.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import novli.auth.authentication.core.properties.BrowserProperties;
import novli.auth.authentication.core.properties.ValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ToString
@ConfigurationProperties(prefix = "novli.nacos")
public class SecurityProperties {

    @Setter
    @Getter
    private BrowserProperties browser = new BrowserProperties();

    @Setter
    @Getter
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public SecurityProperties() {
    }
}
