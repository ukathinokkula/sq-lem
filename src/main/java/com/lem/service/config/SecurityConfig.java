package com.lem.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lem.service.config.security.LemAuthenticationHandler;
import com.lem.service.config.security.LemLogoutSuccessHandler;
import com.lem.service.config.security.LemUserDetailsService;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public LemUserDetailsService lemUserDetailsService() {
		return new LemUserDetailsService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder registry)
			throws Exception {
		registry.userDetailsService(lemUserDetailsService()).passwordEncoder(new Md5PasswordEncoder());

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//@formatter:off
		http
		.sessionManagement()
		.maximumSessions(1)
		.expiredUrl("/lem/login/form?expired")
		.maxSessionsPreventsLogin(false)
		.and()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        .invalidSessionUrl("/").and()
		.csrf()
		.disable()
				.authorizeRequests()
				.antMatchers("/lem/login", "/lem/login/form**","/lem/contact/**", "/lem/homePage","lem/project/**",
						"lem/component/**",
						"/lem/forgotPassword", "/lem/forgotPasswordPage", "/lem/forgotPasswordUpdateDB",
						"/lem/register", "/lem/logout", "/lem/welcomeLemHome",
						"/lem/openSignupPage","/lem/signup","/lem/login/**").permitAll()
				.antMatchers("/lem/admin**", "/lem/admin/**")
				.access("hasRole('admin')")
				.antMatchers("/lem/member**", "/lem/member/**")
				.access("hasAnyRole('member','admin')")
				.antMatchers("/lem/user**", "/lem/user/**")
				.access("hasAnyRole('user','admin')").anyRequest()
				.authenticated().and().formLogin().loginPage("/lem/login/form")
				.successHandler(lemAuthenticationHandler())

				.loginProcessingUrl("/lem/j_spring_security_check")
				.failureUrl("/lem/login/form").permitAll().and()
				.logout()
				.logoutUrl("/lem/j_spring_security_logout")
				.logoutSuccessHandler(lemLogoutSuccessHandler())
				.deleteCookies("JSESSIONID")
				.and()
				.exceptionHandling().accessDeniedPage("/lem/403")
				.and().rememberMe()
				.key("uniqueAndSecret")
			    .tokenValiditySeconds(86400);
	
		
		//@formatter:on

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public LemAuthenticationHandler lemAuthenticationHandler() {
		return new LemAuthenticationHandler();
	}

	@Bean
	public LemLogoutSuccessHandler lemLogoutSuccessHandler() {
		return new LemLogoutSuccessHandler();
	}
}