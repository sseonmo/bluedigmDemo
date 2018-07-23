package com.bluedigm.demo.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	@RequestMapping(value="/")
	public String welcome(){
		return "index";
	}
}
