package com.bluedigm.demo.common.controller;

import com.bluedigm.demo.common.exception.BaseServiceException;
import com.bluedigm.demo.common.exception.InternalServerException;
import com.bluedigm.demo.common.exception.ResourceNotFoundException;
import com.bluedigm.demo.common.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Exception controller advice.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

	/**
	 * Base service exception string.
	 *
	 * @param request the request
	 * @param e       the e
	 * @return the string
	 */
	@ExceptionHandler(BaseServiceException.class)
	public String baseServiceException(HttpServletRequest request, Exception e) {

		logger.debug("ExceptionControllerAdvice - {}", "baseServiceException");

		ErrorMessage errMsg = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getClass().getName(), e.getMessage() );

		if (e instanceof ResourceNotFoundException) {
			ResourceNotFoundException resEx = (ResourceNotFoundException) e;
			errMsg = new ErrorMessage(resEx.getHttpStatus().toString(), resEx.getClass().getName(), resEx.getMessage() );
		}
		else if (e instanceof InternalServerException) {
			InternalServerException intEx = (InternalServerException) e;
			errMsg = new ErrorMessage(intEx.getHttpStatus().toString(), intEx.getClass().getName(), intEx.getMessage() );
		}

		logger.debug("ErrorMessage : {}", errMsg.toString());
		request.setAttribute("errMsg", errMsg);

		return "forward:/errorHandling";
	}

	@ExceptionHandler(Exception.class)
	public String handleAnyException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		logger.debug("ExceptionControllerAdvice - {}", "handleAnyException");

		ErrorMessage errMsg = new ErrorMessage(String.valueOf(response.getStatus()), e.getClass().getName(), e.getMessage() );
		logger.debug("ErrorMessage : {}", errMsg.toString());
		request.setAttribute("errMsg", errMsg);

		return "forward:/errorHandling";
	}

}
