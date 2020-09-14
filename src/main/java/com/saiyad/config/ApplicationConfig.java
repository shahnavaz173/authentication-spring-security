package com.saiyad.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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
}
