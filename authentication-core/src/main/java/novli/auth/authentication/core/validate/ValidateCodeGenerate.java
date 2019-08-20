package novli.auth.authentication.core.validate;


import novli.auth.authentication.core.model.ValidateCode;

import javax.servlet.http.HttpServletRequest;

public interface ValidateCodeGenerate<C extends ValidateCode> {
    /**
     * 生成验证码
     *
     * @author Liyanpeng
     * @date 2019/8/14 13:02
     * @param request
     * @return C
     **/
    C generate(HttpServletRequest request);
}
