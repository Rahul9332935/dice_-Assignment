package com.rahul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

      @Bean
      SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
          httpSecurity.csrf().disable()
                  .authorizeHttpRequests()
                  .anyRequest()
                  .authenticated()
                  .and()
                  .httpBasic();

          return httpSecurity.build();
      }

      @Bean
      InMemoryUserDetailsManager userDetailsService() {
          UserDetails user = User.withDefaultPasswordEncoder()
                  .username("rahul")
                  .password("rahul")
                  .roles("ADMIN")
                  .build();
          return new InMemoryUserDetailsManager(user);
      }
}

