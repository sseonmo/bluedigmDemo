package com.bluedigm.demo.config;

import com.bluedigm.demo.common.jsonSerializer.LocalDateSerializer;
import com.bluedigm.demo.common.xss.HTMLCharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Web configuration.
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

	private static final String[] RESOURCE_LOCATIONS = {
			"classpath:/static/"
	};

	//의미없는 페이지 이동일때 쓰면 괜찮을것 같음
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("/login");
	}

	//정적리소스
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations(RESOURCE_LOCATIONS)
				.setCachePeriod(3600)
				.resourceChain(true)
				.addResolver(new PathResourceResolver());
	}

	/**
	 * Get view resolver view resolver.
	 *
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
//		resolver.setOrder(0);
		return resolver;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		// WebMvcConfigurerAdapter에 MessageConverter 추가
		converters.add(htmlEscapingConveter());
	}

	@Bean
	public HttpMessageConverter<?> htmlEscapingConveter() {
		ObjectMapper objectMapper = new ObjectMapper();
		// ObjectMapper에 특수 문자 처리 기능 적용
		objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());

		// LocalDate 처리
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(LocalDate.class, new LocalDateSerializer());
		objectMapper.registerModule(simpleModule);

		// MessageConverter에 ObjectMapper 설정
		MappingJackson2HttpMessageConverter converter =	new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);

		return converter;
	}

/*
	@Bean
	public MappingJackson2HttpMessageConverter LocalDateMessageConverter(){
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(new LocalDateObjectMaper());
		return converter;
	}
*/

}
