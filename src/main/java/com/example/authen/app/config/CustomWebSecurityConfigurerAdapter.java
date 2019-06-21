package com.example.authen.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable().authorizeRequests()
	            .antMatchers("/","/users/getJsonData","/v2/api-docs", "/configuration/**", "/swagger*/**",
	            		"/webjars/**","/swagger-ui.html"
	            		,"/student_controller/singleStudent",
	            		"/student_controller/listStudent",
	            		"/student_controller_rest/singleStudent",
	            		"/student_controller_rest/listStudent")
	            .permitAll()
	            .antMatchers(HttpMethod.POST, "/login").permitAll()
	            .anyRequest().authenticated()
	            .and()
	            .addFilterBefore(
	                    new JWTAuthenticationProcessingFilter(
	                            "/login", 
	                            authenticationManager()
	                    ),
	                    UsernamePasswordAuthenticationFilter.class
	            ).addFilterBefore(
	                    new JWTGenericFilterBean(),
	                    UsernamePasswordAuthenticationFilter.class
	            );
	    
	    //55
	}

	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("1234"))
                .authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
