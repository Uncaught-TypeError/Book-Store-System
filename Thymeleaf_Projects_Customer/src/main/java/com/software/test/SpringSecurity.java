package com.software.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	
//	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
//		return http.build();
//		}

	
	  @Autowired private UserDetailsService userDetailsService;
	  
	  
	  
	  
	  
		@Bean
		public static PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		/*
		 * @Bean public DaoAuthenticationProvider daoAuthenticationProvider() {
		 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 * authProvider.setUserDetailsService(userDetailsService);
		 * authProvider.setPasswordEncoder(passwordEncoder()); return authProvider; }
		 */

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.authorizeHttpRequests((authorize) -> authorize.antMatchers("/register/**").permitAll()
							.antMatchers("/index").permitAll().antMatchers("/users").hasRole("ADMIN"))
					.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/users")
							.permitAll())
					.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
			return http.build();
		}

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		}
	  
	 
}