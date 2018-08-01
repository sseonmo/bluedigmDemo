package com.bluedigm.demo.api.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bluedigm.demo.api.manager.dao.ManagerMapper;
import com.bluedigm.demo.api.manager.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{

	/** the mapper. */
	@Autowired
	private ManagerMapper managerMapper;
    
	@Override
    public Integer selectManagerList(Pageable pageable) {
        return managerMapper.selectManagerList(pageable);
    }

}
