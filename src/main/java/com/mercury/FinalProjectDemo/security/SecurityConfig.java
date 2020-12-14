package com.mercury.FinalProjectDemo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.FinalProjectDemo.security.handlers.AccessDeniedHandlerImpl;
import com.mercury.FinalProjectDemo.security.handlers.AuthenticationEntryPointImpl;
import com.mercury.FinalProjectDemo.security.handlers.AuthenticationFailureHandlerImpl;
import com.mercury.FinalProjectDemo.security.handlers.AuthenticationSuccessHandlerImpl;
import com.mercury.FinalProjectDemo.security.handlers.LogoutSuccessHandlerImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationEntryPointImpl authenticationEntryPointImpl;
	    
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	    
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	    
	@Autowired
	private AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;
	    
	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.cors()
			.and()
		.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/products", "/products/*", "/index.html").permitAll()
			.antMatchers(HttpMethod.GET, "/orders").hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
//		.exceptionHandling()
//			.authenticationEntryPoint(authenticationEntryPointImpl)
//			.accessDeniedHandler(accessDeniedHandlerImpl)
//			.and()
		.formLogin() // redirect to login page (built in /login servlet)
			.usernameParameter("username")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandlerImpl)
            .failureHandler(authenticationFailureHandlerImpl)
			.and()
		.logout()
//            .permitAll()    
            .logoutUrl("/logout")
            .logoutSuccessHandler(logoutSuccessHandlerImpl)
            .and()
		.httpBasic();
	}
	
	@Bean 
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }
	
	@Autowired   
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // You should only set trusted site here. e.g. http://localhost:4200 means only this site can access.
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","HEAD","OPTIONS"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
