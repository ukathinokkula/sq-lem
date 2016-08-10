package com.lem.service.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lem.service.dao.SecurityDetailDAO;
import com.lem.service.model.SecurityDetails;

@Repository
public class SecurityDetailDAOImpl implements SecurityDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void addSecurityDetail(SecurityDetails securityDetails) {
		getCurrentSession().save(securityDetails);
	}

}
