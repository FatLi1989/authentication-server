package novli.auth.authentication.core.validate.sms;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import novli.auth.authentication.core.SecurityProperties;
import novli.auth.authentication.core.model.ValidateCode;
import novli.auth.authentication.core.validate.ValidateCodeGenerate;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author novLi
 * @date 2019年08月14日 10:50
 */
@Data
@Slf4j
public class SmsCodeGenerate implements ValidateCodeGenerate<ValidateCode> {

    private SecurityProperties securityProperties;

    public SmsCodeGenerate(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public ValidateCode generate(HttpServletRequest request) {
        String smsCode = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        log.info("生成的短信验证码 : 【{}】", smsCode);
        return new ValidateCode(smsCode, securityProperties.getCode().getSms().getExpireIn());
    }
}
