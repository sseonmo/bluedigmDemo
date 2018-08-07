package com.bluedigm.demo.api.manage.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.manage.model.Manage;
import com.bluedigm.demo.api.manage.service.ManageService;

@RestController
@RequestMapping(value = "/api/manage")
public class ManageRestController {

    
	@Autowired
	private ManageService manageService;
	
	
	/**
	 * 리스트
	 */
	@GetMapping(value="/manageList")
	public List<Manage> selectUserList() {
		return manageService.selectManageList();
	}
	
    /**
     * 읽기
     */
	@GetMapping(value="/manageRead")
    public Manage manageRead(HttpServletRequest request, HttpServletResponse response) {
        String ruleId = request.getParameter("ruleId");
        
        Manage manageInfo = manageService.selectManageOne(ruleId);
        
        return manageInfo;
    }
	
	
    /**
    * 사용자 저장.
    */
    @PostMapping(value = "/manageSave")
   public void manageSave(HttpServletResponse response, ModelMap modelMap, Manage manageInfo) {

       manageService.insertManage(manageInfo);
       
   }
    
    /**
    * 사용자 삭제.
    */
   @RequestMapping(value = "/manageDelete")
   public String manageDelete(HttpServletRequest request, ModelMap modelMap, Manage manageInfo) {
       
	   manageService.deleteManage(manageInfo.getRuleId());
       
       return commonManageList(modelMap);
   }  
    
   
   /**
    * 리스트 페이지에서 불러오기위한
    */
   public String commonManageList(ModelMap modelMap) {

       List<Manage> listview  = manageService.selectManageList();
        
       modelMap.addAttribute("listview", listview);
        
       return "manage/manageList";
   }
   
}


