package com.saiyad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {
		"com.saiyad.controller",
		"com.saiyad.auth"
})
@PropertySource("classpath:/props/application.properties")
public class ApplicationConfig extends WebMvcConfigurationSupport {
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
					"css/**","js/**","fonts/**","images/**")
				.addResourceLocations(
					"classpath:/css/","classpath:/js/","classpath:/fonts/","classpath:/images/");
	}
	@Bean
	public InternalResourceViewResolver viewResolver(@Value("${app.view.prefix}") String prefix,
													 @Value("${app.view.suffix}") String suffix){
		InternalResourceViewResolver viewResolver =
				new InternalResourceViewResolver();
		viewResolver.setPrefix(prefix);
		viewResolver.setSuffix(suffix);
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Value("${app.db.driver}") private String driverClass;			
	@Value("${app.db.url}") private String connectionUrl;
	@Value("${app.db.username}") private String userName;
	private String password;
	@Bean
	public DriverManagerDataSource dataSource(){
		password = "mysqladmin";
		DriverManagerDataSource dataSource =
				new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(connectionUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
}
