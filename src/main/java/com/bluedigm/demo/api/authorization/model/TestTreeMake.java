/**
 * 
 */
package com.bluedigm.demo.api.authorization.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bluedigm.demo.api.authorization.service.MenuService;

/**
 * <PRE>
 * 1. ClassName: TestTreeMake
 * 2. FileName : TestTreeMake.java
 * 3. Package  : com.bluedigm.demo.api.authorization.model
 * 4. Comment  :
 * 5. 작성자   : 유형민
 * 6. 작성일   : 2018. 7. 30. 오후 4:21:16
 * 7. 변경이력
 *		이름	:	일자	: 변경내용
 *     ———————————————————————————————————
 *		유형민 :	2018. 7. 30.	: 신규 개발.
 * </PRE>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTreeMake {
	
	@Autowired
	private MenuService menuService;
	
	@Test
	public void testMake() {

		TreeMake tm = new TreeMake();
		
		List<?> listview = menuService.selectMenuList();
		System.out.println(listview);
		String str = tm.makeTree(listview);
		
		System.out.println(str);
/*		[
		 {"key":"1","title":"Root","parent":"0","isFolder":true,
			 "children":[{"key":"2","title":"HOME","parent":"1","isFolder":false,"children":null},
			             {"key":"3","title":"Common","parent":"1","isFolder":false,"children":null},
			             {"key":"4","title":"관리자 관리","parent":"1","isFolder":false,"children":null}
			             ]
		 }
		 ]*/

	}
}
