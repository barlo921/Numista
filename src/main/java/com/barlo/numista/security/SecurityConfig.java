package com.barlo.numista.security;

import com.barlo.numista.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import static com.barlo.numista.model.users.Role.ADMIN;
import static com.barlo.numista.model.users.Role.USER;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder,
                          UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/about", "/connect", "/signup", "/resources/img/**", "/resources/css/**").permitAll()
                .antMatchers("/numista/**").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/numista", true)
                    .permitAll()
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension (){
        return new SecurityEvaluationContextExtension();
    }
}
