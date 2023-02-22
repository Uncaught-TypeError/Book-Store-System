package com.software.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
	
	String myExternalFilePath = "file:///D:/ACM/SpringBootWeb/Springboot Projects/Projects BS/Thymeleaf_Projects_Book_Store/uploads";
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	  {
	    registry.addResourceHandler("/uploads/**").addResourceLocations(myExternalFilePath);
	  }
}

