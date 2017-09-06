package com.yxd.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yxd.po.User;
import com.yxd.util.HibernateSessionFactory;

/**
 * 
 * @author yxd
 * ����Hibernate����ɾ�Ĳ����
 *
 */
public class HibernateCRUD {
	@Test
	public void createTable() {
		HibernateSessionFactory.getSessionFactory();
	}
	
	@Test
	public void insertTable() {
		Session session = HibernateSessionFactory.getSession();
		User user = new User();
		user.setUsername("����");
		user.setPassword("123123");
		user.setGrade("����");
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Serializable id = session.save(user);
			System.out.println("------------------------------------");
			System.out.println(id);
			System.out.println("------------------------------------");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void getTable() {
		Session session = HibernateSessionFactory.getSession();
//		User user = (User) session.get(User.class, 1);
		Query query = session.createQuery("from User u");
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void updateTable() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.getTransaction();
		Query query = session.createQuery("update User u set grade='dansan' where username='����'");
		try {
			tx.begin();
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	@Test
	public void deleteTable() {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.getTransaction();
		Query query = session.createQuery("delete from User where id=1");
		try {
			tx.begin();
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
