package com.lem.service.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lem.service.dao.ComplexityTypeDAO;
import com.lem.service.model.ComplexityType;

@Repository
public class ComplexityTypeDAOImpl implements ComplexityTypeDAO {

	private static final Logger logger = Logger
			.getLogger(ComplexityTypeDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void addComplexityType(ComplexityType complexityTypes) {
		getCurrentSession().save(complexityTypes);
	}

	@Transactional
	public ComplexityType getComplexityTypeById(Long complexityTypeId) {
		ComplexityType complexityType = (ComplexityType) getCurrentSession().get(ComplexityType.class,complexityTypeId);
		return complexityType;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComplexityType> getComplexityTypes() {
		List<ComplexityType> complexityTypeList = (List<ComplexityType>) getCurrentSession()
				.createQuery("from ComplexityType c order by c.id")
				.list();

		return complexityTypeList;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComplexityType> getActiveComplexityTypes() {
		List<ComplexityType> complexityTypeList = (List<ComplexityType>) getCurrentSession()
				.createQuery("from ComplexityType c where c.status=1 order by c.id")
				.list();

		return complexityTypeList;
	}

	@Transactional
	@Override
	public void updateComplexityType(ComplexityType ComplexityType) {
		logger.info("updateComplexityType ID:"+ComplexityType.getId());
		Session session = getCurrentSession();
		session.update(ComplexityType);
		logger.info("ComplexityType data Updated");
	}
}
