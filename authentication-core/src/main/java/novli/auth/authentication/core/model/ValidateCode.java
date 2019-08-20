package novli.auth.authentication.core.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ValidateCode {

    @Setter
    @Getter
    public String code;

    @Setter
    @Getter
    public LocalDateTime expireTime;

    public ValidateCode(String code, int expireTime) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    public boolean isExpire() {
        return LocalDateTime.now().isAfter(this.expireTime);
    }

}
