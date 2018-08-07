package com.bluedigm.demo.api.manage.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluedigm.demo.api.manage.model.Manage;
import com.bluedigm.demo.api.manage.service.ManageService;

@Controller
@RequestMapping(value = "/system/manage")
public class ManagePageController {

	@Autowired
	private ManageService manageService;
	
    /**
     * 리스트.
     */
    @GetMapping(value = "/manage")
       public String manage() {
        
        return "manage/manage";
    }
    
	@GetMapping(value = "/manageViewList")
    public String manageList(HttpServletRequest request, ModelMap modelMap) {

        return commonManageList(modelMap);
    }
	
    public String commonManageList(ModelMap modelMap) {

        List<Manage> listview  = manageService.selectManageList();
        
        modelMap.addAttribute("listview", listview);
        
        return "manage/manageList";
    }
}   
    
