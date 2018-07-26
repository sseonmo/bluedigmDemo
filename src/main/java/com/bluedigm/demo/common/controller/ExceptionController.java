package com.bluedigm.demo.common.controller;

import com.bluedigm.demo.common.model.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Exception controller.
 */
@Controller
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * Sample test model and view.
	 *
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(value = "/errorHandling")
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
	@RequestMapping(value = "/errorHandling", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public ErrorMessage handlerExceptionForJson(HttpServletRequest request) {

		logger.debug("ExceptionController - handlerExceptionForJson");
		return (ErrorMessage) request.getAttribute("errMsg");
	}

}
