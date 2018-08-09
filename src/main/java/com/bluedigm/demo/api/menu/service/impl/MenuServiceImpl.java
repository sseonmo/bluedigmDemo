package com.bluedigm.demo.api.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.menu.dao.MenuMapper;
import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.model.SelectedMenu;
import com.bluedigm.demo.api.menu.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	/** the mapper. */
	@Autowired
	private MenuMapper mapper;


	@Override
	public List<Menu> selectMenuListByRuleId(List<Integer> ruleIds){
		return mapper.selectMenuListByRuleId(ruleIds);
	}

	/**
	 * 전체리스트
	 */
	@Override
	public List<SelectedMenu> selectMenuList(){
	    return mapper.selectMenuList();
	}

	/**
	 * 읽기
	 */
	@Override
	public Menu selectMenuOne(String param){
        return mapper.selectMenuOne(param);
	} 

    /**
     * 저장.
     */
	@Override
    public void insertMenu(Menu param) {
        if ("".equals(param.getPrntMenuId())) {
            param.setPrntMenuId(null);
        }
            
        if (param.getMenuId() == null || "".equals(param.getMenuId())) {
        	param.setCorId("admin");
        	param.setMorId("admin");
        	mapper.insertMenu(param);
        } else {
        	param.setMorId("admin");
        	mapper.updateMenu(param);
        }
    }
    
	/**
	 * 삭제
	 */
	@Override
    public Menu deleteMenu(String param) {
		
		Menu menu = new Menu();
		
		menu.setMorId("admin");
		
		return mapper.deleteMenu(param);
    }
}
