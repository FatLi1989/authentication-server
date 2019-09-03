package novli.auth.authentication.browser.config;

import novli.auth.authentication.browser.authentication.SecurityFailureHandler;
import novli.auth.authentication.browser.authentication.SecuritySuccessHandler;
import novli.auth.authentication.core.SecurityProperties;
import novli.auth.authentication.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import novli.auth.authentication.core.filter.SmsCodeFilter;
import novli.auth.authentication.core.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecuritySuccessHandler securitySuccessHandler;

    @Autowired
    private SecurityFailureHandler securityFailureHandler;

    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier(value = "myUserDetail")
    private UserDetailsService userDetailsService;

    @Autowired
    private SpringSocialConfigurer novLiSpringSocialConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//      jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    //短信登录config
                .apply(smsCodeAuthenticationSecurityConfig)
                  .and()
                //三方登录config
                .apply(novLiSpringSocialConfig)
                   .and()
                //短信验证拦截器
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                //图片验证码拦截器
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //需要账户密码登录的请求全部转到这个请求处理
                .loginPage("/authentication/require")
                //走UserNamePassword
                .loginProcessingUrl("/authentication/form")
                //登录成功处理方式
                .successHandler(securitySuccessHandler)
                //登录失败处理方式
                .failureHandler(securityFailureHandler)
                  .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                    .and()
                //session管理
                .sessionManagement()
                //session无效处理策略
/*
                .invalidSessionStrategy("")
*/
                //同一用户最大session数
                .maximumSessions(1)
                //达到最大数禁止登录（预防并发登录）
                .maxSessionsPreventsLogin(true)
                //session过期处理策略
/*
                .expiredSessionStrategy()
*/
                    .and()
                    .and()
                .authorizeRequests()
                //这些请求路径不需要认证
                .antMatchers("/authentication/require",
                        "/authentication/mobile",
                        securityProperties.getBrowser().getLoginPage(),
                        securityProperties.getBrowser().getSignUpUrl(),
                        "/code/*",
                        "/assets/**",
                        "/user/regist")
                //拥有所有权限
                .permitAll()
                //任何请求
                .anyRequest()
                //需要认证
                .authenticated()
                   .and()
                .csrf().disable();

    }
}
