package com.bluedigm.demo.api.menu.service;

import java.util.List;

import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.model.SelectedMenu;

public interface MenuService {

	/**
	 * <PRE>
	 * 1. MethodName: selectMenuList
	 * 2. ClassName : MenuService
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 28. 오후 2:06:59
	 * </PRE>
	 *   @return List<?>
	 *   @return
	 */
	
	public List<SelectedMenu> selectMenuList();
	
	
	
	public Menu selectMenuOne(String param);



	/**
	 * <PRE>
	 * 1. MethodName: insertMenu
	 * 2. ClassName : MenuService
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:03:05
	 * </PRE>
	 *   @return void
	 *   @param menuInfo
	 */
	
	public void insertMenu(Menu param);



	/**
	 * <PRE>
	 * 1. MethodName: deleteMenu
	 * 2. ClassName : MenuService
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:03:09
	 * </PRE>
	 *   @return void
	 *   @param menuId
	 */
	
	public void deleteMenu(String param);
	
}
