package com.lem.service.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lem.service.dao.EstimationModelTypeDAO;
import com.lem.service.model.EstimationModelType;

@Repository
public class EstimationModelTypeDAOImpl implements EstimationModelTypeDAO {

	private static final Logger logger = Logger
			.getLogger(EstimationModelTypeDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void addEstimationModelType(EstimationModelType categories) {
		getCurrentSession().save(categories);
	}

	@Transactional
	public EstimationModelType getEstimationModelTypeById(Long estimationModelTypeId) {
		EstimationModelType estimationModelType = (EstimationModelType) getCurrentSession().get(EstimationModelType.class,estimationModelTypeId);
		return estimationModelType;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<EstimationModelType> getEstimationModelTypes() {
		List<EstimationModelType> estimationModelTypeList = (List<EstimationModelType>) getCurrentSession()
				.createQuery("from EstimationModelType emt order by emt.id")
				.list();

		return estimationModelTypeList;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<EstimationModelType> getActiveEstimationModelTypes() {
		List<EstimationModelType> estimationModelTypeList = (List<EstimationModelType>) getCurrentSession()
				.createQuery("from EstimationModelType emt where emt.status=1 order by emt.id")
				.list();

		return estimationModelTypeList;
	}

	@Transactional
	@Override
	public void updateEstimationModelType(EstimationModelType EstimationModelType) {
		logger.info("updateEstimationModelType ID:"+EstimationModelType.getId());
		Session session = getCurrentSession();
		session.update(EstimationModelType);
		logger.info("EstimationModelType data Updated");
	}
}
