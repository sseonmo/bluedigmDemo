package com.bluedigm.demo.api.menu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluedigm.demo.api.menu.model.SelectedMenu;
import com.bluedigm.demo.api.menu.model.TreeMake;
import com.bluedigm.demo.api.menu.service.MenuService;

/**
 * The type Menu page controller.
 */
@Controller
@RequestMapping(value = "/system/menu")
public class MenuPageController {

	/** 로그 출력. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenuService menuService;

	/**
	 * 메뉴관리 메인화면.
	 *
	 * @param modelMap the model map
	 * @return String string
	 */
	@GetMapping()
	public String menu(ModelMap modelMap){
	   
		List<SelectedMenu> listview   = menuService.selectMenuList();

	    TreeMake tm = new TreeMake();
	    String treeView = tm.makeTree(listview);
	    
	    modelMap.addAttribute("treeView", treeView);
		
	    return "/menu/menu";
	}

		
}
