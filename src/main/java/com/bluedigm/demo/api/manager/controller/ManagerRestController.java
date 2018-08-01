package com.bluedigm.demo.api.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.manager.service.ManagerService;

@RestController
@RequestMapping(value = "/api/manager")
public class ManagerRestController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** MenuService Autowired. */
	@Autowired
	private ManagerService managerService;

	/** 기본 경로. */ 
	private String thisUrl = "/api/manager";

/*	@GetMapping
	public String managerList(HttpServletRequest request, Manager manager, ModelMap modelMap) {

		//manager.pageCalculate( managerService.selectManagerCount(manager) ); // 페이지
        List<Manager> listview  = managerService.selectManagerList(manager);
        
        modelMap.addAttribute("search", manager);
        modelMap.addAttribute("listview", listview);
        
        return "authorization/manager/managerList";
    }*/
	
	@GetMapping(value="/managerList")
	public String list(Model model, Pageable pageable) {

		model.addAttribute("list", managerService.selectManagerList(pageable));

		return "manager/managerList";
	}
	
}
