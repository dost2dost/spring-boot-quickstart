package com.quickstart.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("dost").password("{noop}test1").roles("user")
                .and()
                .withUser("dm").password("{noop}test2").roles("admin");
    }
    @Override
    protected void configure(HttpSecurity httpSecurity){
        try {
            httpSecurity
                    .authorizeRequests()
                    .anyRequest()
                    .fullyAuthenticated()
                    .and().httpBasic();
            httpSecurity.csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    UserDetailsService user(){
//        return new InMemoryUserDetailsManager(Collections.singleton(User.withUsername("dost").password("{noop}123").roles("admin").build()));
//    }
}
