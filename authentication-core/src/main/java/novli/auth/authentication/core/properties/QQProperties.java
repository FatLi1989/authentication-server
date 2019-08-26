package novli.auth.authentication.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class QQProperties {

    @Setter
    @Getter
    private String appId;

    @Setter
    @Getter
    private String appSecret;

    @Setter
    @Getter
    private String qqProviderId = "qq/callback";
}
