package com.bluedigm.demo.config;

import com.bluedigm.demo.common.message.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSourceConfiguration.class);

    @Value("${spring.messages.basename}")
    private String messageBeans;

    @Value("${spring.errormessages.basename}")
    private String errorMessageBeans;


    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        LOGGER.debug("messageBeans : {}|{}", messageBeans, errorMessageBeans);

        messageSource.setBasenames(messageBeans, errorMessageBeans);
        messageSource.setCacheSeconds(10); // reload messages every 10 seconds
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(false); // True -> locale 에 해당하는 프로퍼티가 없으면 System locale 파일을 찾아간다.

        return messageSource;
    }

    @Bean
    public Messages messages(MessageSource messageSource) {
        return new Messages(messageSource);
    }
}
