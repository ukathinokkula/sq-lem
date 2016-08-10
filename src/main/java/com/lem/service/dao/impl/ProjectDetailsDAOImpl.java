package com.lem.service.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lem.service.dao.ProjectDetailsDAO;
import com.lem.service.model.ProjectDetails;
import com.lem.util.StringUtils;

@Repository
public class ProjectDetailsDAOImpl implements ProjectDetailsDAO {

	private static final Logger logger = Logger
			.getLogger(ProjectDetailsDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Long addProjectDetails(ProjectDetails projectDetails) {
		return (Long) getCurrentSession().save(projectDetails);
	}

	@Transactional
	public ProjectDetails getProjectDetailsById(Long projectDetailsId) {
		ProjectDetails projectDetails = (ProjectDetails) getCurrentSession()
				.get(ProjectDetails.class,projectDetailsId);
		return projectDetails;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> getProjectDetails() {
		List<ProjectDetails> projectDetailsList = (List<ProjectDetails>) getCurrentSession()
				.createQuery("from ProjectDetails p order by p.id").list();

		return projectDetailsList;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ProjectDetails> getActiveProjectDetails() {
		List<ProjectDetails> projectDetailsList = (List<ProjectDetails>) getCurrentSession()
				.createQuery("from ProjectDetails p where p.status=1 order by p.id").list();

		return projectDetailsList;
	}

	@Transactional
	@Override
	public void updateProjectDetails(ProjectDetails projectDetails) {
		logger.info("updateProjectDetails ID:"+projectDetails.getId());
		Session session = getCurrentSession();
		session.update(projectDetails);
		logger.info("ProjectDetails data Updated");
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectDetails> searchReport(String projectName,
			Double totalHoursFrom, Double totalHoursTo, Date fromDate,
			Date toDate) {

		StringBuffer query = new StringBuffer("from ProjectDetails p where ");
		String projectNameQry = "";
		String datesQry = "";
		String totalHoursQry = "";
		boolean isAndReq = false;
		
		if (!StringUtils.isEmptyOrNull(projectName)) {
			projectNameQry = " p.name like :projectName ";
		}
		if (fromDate != null && toDate != null) {
			datesQry = " p.createdDate between :fromDate and :toDate";
		}
		if (totalHoursFrom != null && totalHoursTo != null) {
			totalHoursQry = " p.id in (select cl.projectDetails.id from ComponentList cl"
					+ " where cl.status=1 group by cl.projectDetails.id having sum(cl.totalHours)"
					+ " between :totalHoursFrom and :totalHoursTo)";
		}
		
		if (projectNameQry.length() > 0) {
			query.append(projectNameQry);
			isAndReq = true;
		}
		if(datesQry.length() > 0) {
			query.append(isAndReq ? " and " : "").append(datesQry);
			isAndReq = true;
		}
		if(totalHoursQry.length() > 0) {
			query.append(isAndReq ? " and " : "").append(totalHoursQry);
		}
		
		Query  q = getCurrentSession().createQuery(query.toString());
		
		if(projectNameQry.length() > 0 ) {
			q.setParameter("projectName", projectName);
		} if(datesQry.length()>0) {
			q.setParameter("fromDate", fromDate).setParameter("toDate", toDate);
		} if (totalHoursQry.length()>0 ) {
			q.setParameter("totalHoursFrom", totalHoursFrom).setParameter("totalHoursTo", totalHoursTo);
		}
		List<ProjectDetails> projectDetailsList =(List<ProjectDetails>) q.list();
		return projectDetailsList;
	}
}
