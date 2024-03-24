package com.gl.Debate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gl.Debate.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig 
{

	@Bean
	public DaoAuthenticationProvider myAuth() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUser());
        authProvider.setPasswordEncoder(myPas());
        return authProvider;
	}

	@Bean
	public BCryptPasswordEncoder myPas() {
        return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService myUser() {
        return new UserDetailsServiceImpl();
	}
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/studentdetails/save").hasAnyAuthority("USER", "ADMIN")
        .antMatchers("/","/students/showFormForAdd","/students/403").hasAnyAuthority("user","admin")
        .antMatchers("/students/showFormForUpdate","/students/delete").hasAuthority("admin")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/students/list").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/students/403")
        .and()
        .cors().and().csrf().disable();
        
		http.authenticationProvider(myAuth());
        
        return http.build();
    }

}