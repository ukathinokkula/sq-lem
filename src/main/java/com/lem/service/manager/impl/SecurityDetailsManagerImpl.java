package com.lem.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lem.service.dao.SecurityDetailDAO;
import com.lem.service.manager.SecurityDetailsManager;
import com.lem.service.model.SecurityDetails;

@Service
public class SecurityDetailsManagerImpl implements SecurityDetailsManager{
	
	@Autowired
	protected SecurityDetailDAO securityDetailDao;
	

	@Override
	public void addSecurityDetails(SecurityDetails securityDetail) {
		securityDetail.setCreatedBy("Default User");
		securityDetailDao.addSecurityDetail(securityDetail);
	}
	
	

}
