package com.bluedigm.demo.api.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bluedigm.demo.api.menu.model.Menu;
import com.bluedigm.demo.api.menu.model.SelectedMenu;

@Mapper
@Repository
public interface MenuMapper {

	/**
	 * 
	 * <PRE>
	 * 1. MethodName: selectMenuList
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:07:49
	 * </PRE>
	 *   @return List<?>
	 *   @return
	 */
	List<SelectedMenu> selectMenuList();
	
	
	/**
	 * 
	 * <PRE>
	 * 1. MethodName: selectMenuOne
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:07:52
	 * </PRE>
	 *   @return Menu
	 *   @param param
	 *   @return
	 */
	Menu selectMenuOne(String param);

	/**
	 * <PRE>
	 * 1. MethodName: insert
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:06:03
	 * </PRE>
	 *   @return void
	 *   @param string
	 *   @param param
	 */
	
	void insert(String string, Menu param);

	/**
	 * <PRE>
	 * 1. MethodName: insertMenu
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:07:22
	 * </PRE>
	 *   @return void
	 *   @param param
	 */
	
	void insertMenu(Menu param);

	/**
	 * <PRE>
	 * 1. MethodName: updateMenu
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:07:30
	 * </PRE>
	 *   @return void
	 *   @param param
	 */
	
	void updateMenu(Menu param);

	/**
	 * <PRE>
	 * 1. MethodName: deleteMenu
	 * 2. ClassName : MenuMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 30. 오전 9:07:36
	 * </PRE>
	 *   @return void
	 *   @param param
	 */
	
	Menu deleteMenu(String param);
	
}