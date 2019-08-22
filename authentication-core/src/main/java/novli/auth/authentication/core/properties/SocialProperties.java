package novli.auth.authentication.core.properties;

import lombok.Getter;
import lombok.Setter;

public class SocialProperties {

    @Setter
    @Getter
    private String filterProcessesUrl;

    @Setter
    @Getter
    private QQProperties qq;
}
