package com.bluedigm.demo.api.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.authorization.dao.ManagerMapper;
import com.bluedigm.demo.api.authorization.dao.MenuMapper;
import com.bluedigm.demo.api.authorization.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	/** the mapper. */
	@Autowired
	private ManagerMapper managerMapper;


}
