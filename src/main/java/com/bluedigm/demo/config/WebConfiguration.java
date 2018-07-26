package com.bluedigm.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
//@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

	private static final String[] RESOURCE_LOCATIONS = {
			"classpath:/static/"
	};

	// 정적리소스 config
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations(RESOURCE_LOCATIONS)
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
	}

}
