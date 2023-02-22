//package com.software.test;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AnyRequestMatcher;
//
//@Configuration
//public class SecurityConfig {
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	public CustomUserDetailService userDetailService() {
//		return new CustomUserDetailService();
//	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(passwordEncoder());
//		provider.setUserDetailsService(userDetailService());
//		return provider;
//	}
//	public void configure(AuthenticationManagerBuilder builder) {
//		builder.authenticationProvider(authenticationProvider());
//	}
//	
//	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/bookform").hasAnyAuthority("ADMIN")
//		.and().formLogin().permitAll()	
//		.and().logout().permitAll();
//		return http.build();
//		}
//}
