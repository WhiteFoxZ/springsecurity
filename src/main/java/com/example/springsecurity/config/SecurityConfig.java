package com.example.springsecurity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    // 스프링 시큐리티에서는 비밀번호를 암호화해서 저장해야 합니다. 이때 사용할 암호화 클래스입니다.
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 시큐리티 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // csrf 보안 해제 (개발 환경에서 설정시 복잡성) 가동계에서는 주석처리 필요.
        http.csrf(csrf -> csrf.disable());

        // 접근 경로별 인가 설정
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll()

        );


//        http.formLogin(
//                httpSecurityFormLoginConfigurer -> {
//                }
//        );

        //SpringSecurity 기본form login사용
        http.formLogin(
                httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage("/login")
                            .loginProcessingUrl("/loginProc")   //로그인 html에서 form action 값으로 설정할값
                            .defaultSuccessUrl("/success",true)
                            .failureUrl("/failed")
                            .usernameParameter("username")
                            .passwordParameter("password")
                            .failureHandler((request, response, exception) -> {

                                log.debug("실패 핸들러");
                            })
                            .successHandler((request, response, authentication) -> {
                                log.debug("성공 핸들러");
                                log.debug("getDetails :"+authentication.getDetails());
                                log.debug("getPrincipal : "+authentication.getPrincipal());
                                //log.debug("메인페이지로 이동 : ");
                                //response.sendRedirect("/");

                            }).permitAll()  //로그인 페이지 및 로그인 처리 URL에 대한 접근을 모든 사용자에게 허용합니다.

                    ;
                }

        );


        return http.build();
    }


}
