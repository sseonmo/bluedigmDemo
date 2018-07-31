package com.bluedigm.demo.api.authorization.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.authorization.model.Menu;
import com.bluedigm.demo.api.authorization.model.UtilEtc;
import com.bluedigm.demo.api.authorization.service.MenuService;

@RestController
@RequestMapping(value = "/api/authorization/menu")
public class MenuRestController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** MenuService Autowired. */
	@Autowired
	private MenuService menuService;

	/** 기본 경로. */ 
	private String thisUrl = "/api/authorization/menu";

    /**
     * 읽기.
     */
	@GetMapping(value = "/menuRead")
    public void menuRead(HttpServletRequest request, HttpServletResponse response) {
     
		String menuId = request.getParameter("menuId");
     	Menu menuInfo = menuService.selectMenuOne(menuId);
	
     	UtilEtc.responseJsonValue(response, menuInfo);
	}
	
    /**
     * 쓰기.
     */ 
	@PostMapping(value = "/menuSave")
       public void menuSave(HttpServletResponse response, Menu menuInfo) {
        
    	menuService.insertMenu(menuInfo);
    	
    	UtilEtc.responseJsonValue(response, menuInfo);
    }
	
    /**
     * 삭제.
     */
	@DeleteMapping(value = "/menuDelete")
       public void menuDelete(HttpServletRequest request, HttpServletResponse response) {
        
        String menuId = request.getParameter("menuId");
        
        menuService.deleteMenu(menuId);
        
        UtilEtc.responseJsonValue(response, "OK");
        
    }
}
