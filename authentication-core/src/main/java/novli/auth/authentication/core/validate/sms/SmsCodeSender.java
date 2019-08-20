package novli.auth.authentication.core.validate.sms;

public interface SmsCodeSender{


    void sendLogin(String mobile, String code);
}
