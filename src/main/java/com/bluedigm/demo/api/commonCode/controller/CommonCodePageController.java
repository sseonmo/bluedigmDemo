/**
 * 
 */
package com.bluedigm.demo.api.commonCode.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ayeon
 * @date 2018. 7. 25.
 *
 */
@Controller
@RequestMapping(value = "/system/commonCode")
public class CommonCodePageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping
	public String commonCode(){
		logger.debug("debug  - SamplePageController - commonCode");
		logger.info("info - SamplePageController - commonCode");
		return "/code/commonCode";
	}
}
