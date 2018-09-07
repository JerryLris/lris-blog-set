package com.lris.ain.blog.ainblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * 自定义配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()// 都可以访问
			.antMatchers("/users/**").hasRole("ADMIN")// 需要相应的角色才能访问
			.and()
			.formLogin().loginPage("/login").failureUrl("/login-error").defaultSuccessUrl("/index")//基于 Form 表单登录验证,自定义登录界面
			.and()
			.exceptionHandling().accessDeniedPage("/403");// 处理异常，拒绝访问就重定向到 403 页面

		 }
	
	/**
	 * 认证信息管理
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("lris").password("123456").roles("ADMIN");
	}

}
