package com.lem.service.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lem.service.dao.ComponentListDAO;
import com.lem.service.model.ComponentList;

@Repository
public class ComponentListDAOImpl implements ComponentListDAO {

	private static final Logger logger = Logger
			.getLogger(ComponentListDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void addComponentList(ComponentList componentList) {
		getCurrentSession().save(componentList);
	}

	@Transactional
	public ComponentList loadComponentListById(Long componentListId) {
		ComponentList componentList = (ComponentList) getCurrentSession().get(ComponentList.class,componentListId);
		return componentList;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComponentList> loadComponentListsByProjectId(Long projectId) {
		List<ComponentList> componentList = (List<ComponentList>) getCurrentSession()
				.createQuery("from ComponentList c where c.projectDetails.id=:projectId order by c.id")
				.setParameter("projectId", projectId)
				.list();

		return componentList;
	}

	@Transactional
	@Override
	public void updateComponentList(ComponentList ComponentList) {
		logger.info("updateComponentList ID:"+ComponentList.getId());
		Session session = getCurrentSession();
		session.update(ComponentList);
		logger.info("ComponentList data Updated");
	}
	
	@Transactional
	public Double loadTotalProjectHours(Long projectId, int status) {
		Double totalProjectHours = (Double) getCurrentSession()
				.createQuery("select sum(c.totalHours) from ComponentList c where c.projectDetails.id=:projectId and c.status=:status")
				.setParameter("projectId", projectId)
				.setParameter("status", status).uniqueResult();

		return totalProjectHours;
	}
	
	@Transactional
	public Double loadTotalProjectHoursByIds(Long[] selectedComponentIds) {
		
		Double totalProjectHours = (Double) getCurrentSession()
				.createQuery("select sum(c.totalHours) from ComponentList c where c.id in (:selectedComponentIds)")
				.setParameterList("selectedComponentIds", selectedComponentIds).uniqueResult();

		return totalProjectHours;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ComponentList> loadComponentsByProjectIdAndStatus(Long projectId, int status) {
		List<ComponentList> componentList = (List<ComponentList>) getCurrentSession()
				.createQuery("from ComponentList c where c.projectDetails.id=:projectId and c.status=:status order by c.id")
				.setParameter("projectId", projectId).setParameter("status", status)
				.list();

		return componentList;
	}
}
