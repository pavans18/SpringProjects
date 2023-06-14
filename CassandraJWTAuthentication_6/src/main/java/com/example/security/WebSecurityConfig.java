package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.jwt.AuthEntryPointJwt;
import com.example.security.jwt.AuthTokenFilter;
import com.example.security.services.UserDetailsImpl;
import com.example.security.services.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletResponse;




@SuppressWarnings("deprecation")
@Configuration
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig { 
	
  @Autowired
  UserDetailsServiceImpl userDetailsService;
 
  @Autowired
   AuthenticationEntryPoint unauthorizedHandler;

//  @Autowired
//  private AuthEntryPointJwt unauthorizedHandler;
  

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(passwordEncoder());
   
      return authProvider;
  }

  
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//      .antMatchers("/api/test/**").permitAll()
//      .anyRequest().authenticated();
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//  }
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	  
	  http.headers().httpStrictTransportSecurity().disable();
	  
	 return http.csrf().disable()
		  .exceptionHandling().authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
        .exceptionHandling()
        .authenticationEntryPoint(this.unauthorizedHandler)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
		  .authorizeHttpRequests()
		 
        .requestMatchers("/customer/savecustomer","/customer/getAllCustomers","/customer/auth/addUser","/customer/getCustomerById/{id}")
        .permitAll()
        .and()
        //.authorizeHttpRequests().requestMatchers("/customer/updateCustomerById/{id}","/customer/deleteCustomerById/{id}")
//        .authorizeHttpRequests().anyRequest()
        .authorizeHttpRequests().requestMatchers("/customer/**")
        .authenticated().and().formLogin().and().build();
 				
  }
  
  @Bean
  public AuthenticationProvider authenticationProviderc() {
	  DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	  authenticationProvider.setUserDetailsService(userDetailsService);
	  authenticationProvider.setPasswordEncoder(passwordEncoder());
	  return authenticationProvider;
  }
}


//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     			http.csrf().disable()
  		  //.exceptionHandling().authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
//            .exceptionHandling()
//            .authenticationEntryPoint(this.unauthorizedHandler)
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//  		  .authorizeHttpRequests()
//            .requestMatchers("/api/customer/savecustomer","/api/customer/getAllcustomers","/api/auth/addUser","/api/customer/getCustomerById/{id}")
//            .permitAll()
//            .and()
//            .authorizeHttpRequests().requestMatchers("/api/updateCustomerById/{id}","/api/deleteCustomerById/{id}")
//            .authenticated().and().formLogin();
//     			
//     			return http.build();
//     			
//     			
//}