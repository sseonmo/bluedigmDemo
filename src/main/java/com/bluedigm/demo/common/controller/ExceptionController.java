package com.bluedigm.demo.common.controller;

import com.bluedigm.demo.common.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * The type Exception controller.
 */
@Controller
@RequestMapping(value = "/error")
public class ExceptionController implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * Sample test model and view.
	 *
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/handling")
	public ModelAndView handlerExceptionForHtml(HttpServletRequest request) {

		logger.debug("ExceptionController - handlerExceptionForHtml");
		ErrorMessage errMsg = (ErrorMessage) request.getAttribute("errMsg");
		ModelAndView mv = new ModelAndView("/error/error");
		mv.addObject("errMsg", errMsg);

		return mv;
	}

	/**
	 * Handle custom exception response entity.
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@RequestMapping(value = "/handling", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public ErrorMessage handlerExceptionForJson(HttpServletRequest request) {

		logger.debug("ExceptionController - handlerExceptionForJson");
		return (ErrorMessage) request.getAttribute("errMsg");
	}

	/**
	 * Handle error string.
	 *
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping
	public String handlerError(HttpServletRequest request) {

		String errorPage = getErrorPath();

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		switch (HttpStatus.valueOf(Integer.valueOf(status.toString()))) {
			case UNAUTHORIZED:
				errorPage = "/error/401";
				break;
			case FORBIDDEN:
				errorPage = "/error/403";
				break;
			case NOT_FOUND:
				errorPage = "/error/404";
				break;
		}
		return errorPage;
	}

	@Override
	public String getErrorPath() {
		return "/error/error";
	}
}
