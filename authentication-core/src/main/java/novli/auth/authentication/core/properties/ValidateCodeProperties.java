package novli.auth.authentication.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ValidateCodeProperties {

    @Setter
    @Getter
    private ImageCodeProperties image = new ImageCodeProperties();

    @Setter
    @Getter
    private SmsCodeProperties sms = new SmsCodeProperties();

    public ValidateCodeProperties() {
    }
}
