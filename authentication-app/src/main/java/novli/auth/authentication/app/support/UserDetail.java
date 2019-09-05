package novli.auth.authentication.app.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "appUserDetail")
public class UserDetail implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 表单登录使用
     *
     * @param userName
     * @return UserDetails
     * @author NovLi
     * @date 2019/8/22
     **/
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("表单登录用户名: {}", userName);
        return buildUser(userName);
    }

    /**
     * 社交软件登录时使用
     *
     * @param userId
     * @return SocialUserDetails
     * @author NovLi
     * @date 2019/8/22
     **/
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("社交登录用户id: {}", userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userName) {
        log.info("password: {}", passwordEncoder.encode("123456"));
        String password = passwordEncoder.encode("123456");
        return new SocialUser("123", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin, ROLE_USERS"));
    }


}
