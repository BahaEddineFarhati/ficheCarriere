/*package com.bct.ficheCarriere.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure authentication (in-memory, JDBC, LDAP, etc.)
        auth.inMemoryAuthentication()
                .withUser("cons")
                .password(passwordEncoder().encode("cons123"))
                .roles("CONS");
        auth.inMemoryAuthentication()
                .withUser("study")
                .password(passwordEncoder().encode("study123"))
                .roles("STUDY");
        auth.inMemoryAuthentication()
                .withUser("rh")
                .password(passwordEncoder().encode("rh123"))
                .roles("RH");
        auth.inMemoryAuthentication()
                .withUser("project")
                .password(passwordEncoder().encode("project123"))
                .roles("PROJECT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/study/**").hasRole("STUDY")
                .antMatchers("/project/**").hasRole("PROJECT")
                .antMatchers("/rh/**").hasRole("RH")
                .antMatchers("/cons/**").hasRole("CONS")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/listEmployees", true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().httpBasic().and().csrf().disable(); // Added this line to disable HTTP Basic and CSRF


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCryptPasswordEncoder for password encoding
        return new BCryptPasswordEncoder();
    }
}
*/