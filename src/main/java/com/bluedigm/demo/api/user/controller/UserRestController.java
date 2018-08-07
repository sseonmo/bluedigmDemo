package com.bluedigm.demo.api.user.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluedigm.demo.api.user.model.User;
import com.bluedigm.demo.api.user.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/userList")
	public List<User> selectUserList() {
		return userService.selectUserList();
	}
    
	   /**
	   * ID 중복 확인.
	   */
    @PostMapping(value = "/chkUserId")
    public String chkUserid(User user) {

    	int result = userService.selectUserId(user.getUserId());

    	return String.valueOf(result);
    }	
	
    /**
     * 읽기
     */
	@GetMapping(value="/userRead")
    public User userRead(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        
        User userInfo = userService.selectUserOne(userId);
        
        return userInfo;
    }
	
	
    /**
    * 사용자 저장.
    * 신규 사용자는 저장 전에 중복 확인 
    */
   @PostMapping(value = "/userSave")
   public void userSave(User userInfo) {

       userService.insertUser(userInfo);
   }
    
   /**
    * 사용자 권한 저장 
    */
    @PostMapping(value="/userRuleSave")
    public void userRuleSave(User userInfo){
    	userService.insertUserRule(userInfo);
    }

    /**
    * 사용자 삭제.
    */
   @RequestMapping(value = "/userDelete")
   public String userDelete(HttpServletRequest request, ModelMap modelMap, User userInfo) {
       
	   userService.deleteUser(userInfo.getUserId());
       
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

    
