package ukjjang.jwt.com.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 기본적인 web 보안을 활성화 시키는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // request 요청 제한을 설정
                .antMatchers("/jwt/hello").permitAll() // 인증없이 접근을 허용하겠다.
                .anyRequest().authenticated(); // 인증을 받아야한다.
    }
}
