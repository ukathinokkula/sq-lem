package com.lem.service.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lem.service.dao.UserDAO;
import com.lem.service.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.openSession();
	}

	/**
	 * This method will return the User object based on userName.
	 */
	public User findByName(String username) {
		User user = (User) getCurrentSession()
				.createQuery("from User where username = :username")
				.setParameter("username", username).uniqueResult();
		return user;
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);

	}

	@Override
	public void updateLastLoginDateByName(String userName) {

		User user = new User();
		try {
			Session session = getCurrentSession();
			Transaction ts = session.beginTransaction();
			user = (User) getCurrentSession()
					.createQuery("from User where username = :username ")
					.setParameter("username", userName).uniqueResult();
			user.setLastLoginDate(new Date());
			session.update(user);
			ts.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		Session session = getCurrentSession();
		Transaction ts = session.beginTransaction();
		User u = (User) session.get(User.class, user.getId());
		u.setChangeDate();
		session.update(u);
		ts.commit();
		session.close();
	}

	@Override
	public boolean verifyUsername(String username) {
		User user = (User) findByName(username);
		return (user != null ? true : false);
	}

	@Override
	public boolean savePassword(User userObj) {
		/*
		 * Query query = getCurrentSession().createQuery(
		 * "update User set password=:updatePassword where username = :username"
		 * ); query.setParameter("updatePassword", user.getPassword());
		 * query.setParameter("username", user.getUsername()); int i =
		 * query.executeUpdate();
		 */
		try {
			Session session = getCurrentSession();
			Transaction trx = session.beginTransaction();
			User user = (User) session.get(User.class, userObj.getId());
			user.setPassword(userObj.getPassword());
			session.update(user);
			trx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		/*
		 * System.out.println("Sucess or faiulure   "+i);
		 * 
		 * return (i == 0 ? false : true);
		 */
	}

	@SuppressWarnings("unchecked")
	public List<User> loadUserDetails() {
		List<User> userList = (List<User>) getCurrentSession().createQuery(
				"from User u order by u.updatedDate").list();

		return userList;
	}

	/**
	 * Using this method we can load the members based on user name and date.
	 */
	@SuppressWarnings("unchecked")
	public List<User> loadMebersBySearchCriteria(String userName,
			Date fromDate, Date toDate) {
		logger.info("loadMebersBySearchCriteria userName:" + userName
				+ " fromDate :" + fromDate + " toDate" + toDate);
		StringBuffer sb = new StringBuffer(
				"from User u where u.username like :userName");
		if (null != fromDate && null != toDate) {
			sb.append(" and u.lastLoginDate between :fromDate and :toDate");
		}
		sb.append(" order by u.updatedDate");

		Query query = getCurrentSession().createQuery(sb.toString())
				.setParameter("userName", userName + "%");
		if (null != fromDate && null != toDate) {
			query.setParameter("fromDate", fromDate).setParameter("toDate",
					toDate);
		}
		List<User> userList = (List<User>) query.list();

		return userList;
	}
}
