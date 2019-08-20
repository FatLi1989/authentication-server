package novli.auth.authentication.core.validate.sms.tencent;

import novli.auth.authentication.core.SecurityProperties;
import novli.auth.authentication.core.validate.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author novLi
 * @date 2019年08月15日 17:05
 */
@Component("tencentSmsCodeSender")
public class TencentSmsCodeSender implements SmsCodeSender {

    @Autowired
    private SecurityProperties securityProperties;

  /*  public TencentSmsCodeSender(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }*/

    @Override
    public void sendLogin(String mobile, String code) {

    }
}
