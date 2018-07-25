package com.bluedigm.demo.common.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

/**
 * The type Messages.
 */
public class Messages {

	private MessageSourceAccessor accessor;

	private static final Logger LOGGER = LoggerFactory.getLogger(Messages.class);

	/**
	 * Instantiates a new Messages.
	 *
	 * @param messageSource the message source
	 */
	public Messages(MessageSource messageSource) {
		this.accessor = new MessageSourceAccessor(messageSource);
	}

	/**
	 * Gets message.
	 *
	 * @param code the code
	 * @return the message
	 */
	public String getMessage(String code) {
		return get(code, locale(), new Object[]{null});
	}

	/**
	 * Gets message.
	 *
	 * @param code the code
	 * @param obj  the obj
	 * @return the message
	 */
	public String getMessage(String code, Object... obj) {
		return get(code, locale(), obj);
	}

	/**
	 * Gets message.
	 *
	 * @param code   the code
	 * @param locale the locale
	 * @return the message
	 */
	public String getMessage(String code, Locale locale) {
		return get(code, locale, new Object[]{null});
	}

	/**
	 * Gets message.
	 *
	 * @param code   the code
	 * @param locale the locale
	 * @param obj    the obj
	 * @return the message
	 */
	public String getMessage(String code, Locale locale, Object... obj) {
		return get(code, locale, obj);
	}

	/**
	 * Gets message.
	 *
	 * @param code the code
	 * @return the message
	 */
	public String getMessage(Code code) {
		return getMessage(code.getCode());
	}

	/**
	 * Gets message.
	 *
	 * @param code the code
	 * @param obj  the obj
	 * @return the message
	 */
	public String getMessage(Code code, Object... obj) {
		return getMessage(code.getCode(), obj);
	}

	/**
	 * Gets message.
	 *
	 * @param code   the code
	 * @param locale the locale
	 * @return the message
	 */
	public String getMessage(Code code, Locale locale) {
		return getMessage(code.getCode(), locale);
	}

	/**
	 * Gets message.
	 *
	 * @param code   the code
	 * @param locale the locale
	 * @param obj    the obj
	 * @return the message
	 */
	public String getMessage(Code code, Locale locale, Object... obj) {
		return getMessage(code.getCode(), locale, obj);
	}

	private String get(String code, Locale locale, Object... obj) {
		LOGGER.info("Trying find message : {} / {} / {}", code, locale, obj);
		return accessor.getMessage(code, obj, locale);
	}

	private Locale locale() {
		return LocaleContextHolder.getLocale();
	}
}
