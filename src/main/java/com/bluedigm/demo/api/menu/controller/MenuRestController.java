package com.bluedigm.demo.api.menu.controller;

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

import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.service.MenuService;
import com.bluedigm.demo.common.message.Messages;

@RestController
@RequestMapping(value = "/api/menu")
public class MenuRestController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** MenuService Autowired. */
	@Autowired
	private MenuService menuService;

    /**
     * 읽기.
     */
	@GetMapping(value = "/menuRead")
    public Menu menuRead(HttpServletRequest request, HttpServletResponse response) {
     
		String menuId = request.getParameter("menuId");
     	Menu menuInfo = menuService.selectMenuOne(menuId);
	
     	return menuInfo;
	}
	
    /**
     * 쓰기.
     */ 
	@PostMapping(value = "/menuSave")
       public void menuSave(HttpServletResponse response, Menu menuInfo) {
        
    	menuService.insertMenu(menuInfo);
    	
    }
	
    /**
     * 삭제.
     */
	@PostMapping(value = "/menuDelete")
       public Menu menuDelete(HttpServletRequest request, HttpServletResponse response) {
        
        String menuId = request.getParameter("menuId");
        
        Menu menuInfo = menuService.deleteMenu(menuId);
        
        return menuInfo;
    }
}
