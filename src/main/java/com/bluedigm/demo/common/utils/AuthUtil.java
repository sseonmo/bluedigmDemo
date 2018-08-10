package com.bluedigm.demo.common.utils;

import com.bluedigm.demo.common.security.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * The type Auth util.
 */
public class AuthUtil {

	/**
	 * Gets current user id.
	 *
	 * @return the current user id
	 */
	public static String getCurrentUserId() {
		return getCurrentUser().getUsername();
	}

	/**
	 * Gets current user.
	 *
	 * @return the current user
	 */
	public static CustomUser getCurrentUser() {
		return (CustomUser) getAuthentication().getPrincipal();
	}

	/**
	 * Is authenticated boolean.
	 *
	 * @return the boolean
	 */
	public static boolean isAuthenticated() {
		return !"anonymousUser".equals(getAuthentication().getPrincipal());
	}

	/**
	 * Gets authentication.
	 *
	 * @return the authentication
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
