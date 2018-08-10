package com.visa.prj.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ViewConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundle= new  ResourceBundleMessageSource();
		//it will look for messages.property as we have set base name
		//property file is a key value pair
		bundle.setBasename("messages");
		return bundle;
	}
}
