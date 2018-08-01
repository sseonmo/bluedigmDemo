package com.bluedigm.demo.api.manager.service;

import org.springframework.data.domain.Pageable;

public interface ManagerService {

	/**
	 * <PRE>
	 * 1. MethodName: selectManagerList
	 * 2. ClassName : ManagerService
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 31. 오후 2:46:23
	 * </PRE>
	 *   @return Object
	 *   @param pageable
	 *   @return
	 */
	
	Object selectManagerList(Pageable pageable);


	

	
	
}
