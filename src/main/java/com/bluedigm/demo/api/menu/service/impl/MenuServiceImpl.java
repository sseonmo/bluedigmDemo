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
	private MenuMapper menuMapper;

	/**
	 * 전체리스트
	 */
	@Override
	public List<SelectedMenu> selectMenuList(){
	    return menuMapper.selectMenuList();
	}

	/**
	 * 읽기
	 */
	@Override
	public Menu selectMenuOne(String param){
        return menuMapper.selectMenuOne(param);
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
        	menuMapper.insertMenu(param);
        } else {
        	param.setMorId("admin");
        	menuMapper.updateMenu(param);
        }
    }
    
	/**
	 * 삭제
	 */
	@Override
    public void deleteMenu(String param) {
    	menuMapper.deleteMenu(param);
    }
}
