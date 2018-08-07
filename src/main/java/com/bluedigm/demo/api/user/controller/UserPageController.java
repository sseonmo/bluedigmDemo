package com.bluedigm.demo.api.user.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluedigm.demo.api.user.model.User;
import com.bluedigm.demo.api.user.service.UserService;

@Controller
@RequestMapping(value = "/system/user")
public class UserPageController {

	@Autowired
	private UserService userService;
	
    /**
     * 리스트.
     */
    @GetMapping(value = "/user")
       public String user() {
        
       return "user/user";
    }
    
    /**
     * User 리스트.
     */
    @GetMapping(value = "/userViewList")
    public String userList(HttpServletRequest request, ModelMap modelMap) {

        return common_UserList(modelMap);
    }
    
    /**
     * 지정된 부서의 사용자 리스트.     
     */
    public String common_UserList(ModelMap modelMap) {

        List<User> listview  = userService.selectUserList();
        
        modelMap.addAttribute("listview", listview);
        
        return "user/userList";
    } 
    
    
}   


