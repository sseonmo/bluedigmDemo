package com.bluedigm.demo.api.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagerMapper {

	/**
	 * <PRE>
	 * 1. MethodName: selectManagerList
	 * 2. ClassName : ManagerMapper
	 * 3. Comment   :
	 * 4. 작성자    : 유형민
	 * 5. 작성일    : 2018. 7. 31. 오후 2:47:13
	 * </PRE>
	 *   @return Integer
	 *   @param pageable
	 *   @return
	 */
	
	Integer selectManagerList(Pageable pageable);

	
}