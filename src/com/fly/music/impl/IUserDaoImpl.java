package com.fly.music.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.fly.music.dao.UserDao;
import com.fly.music.entity.User;
import com.fly.music.util.HibernateUtil;


public class IUserDaoImpl<T> implements UserDao{

	@Override
	public List getUser(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println(username);
		System.out.println(password);
		 List<T> list = new ArrayList<>();
	        Session session = HibernateUtil.getSession();
	        String hql = "from User where username = ? and password = ?";
	        try {
	        	
	            Query query = session.createQuery(hql);
	            query.setParameter(0, username);
	            query.setParameter(1, password);
	            list = query.list();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        finally {
	            HibernateUtil.closeSession(session);
	        }  
	        System.out.println(list);
	        return list;
		
	}
	
	
	@Override
	public List getUser(String username) {
		// TODO Auto-generated method stub
		System.out.println(username);
		
		 List<T> list = new ArrayList<>();
	        Session session = HibernateUtil.getSession();
	        String hql = "from User where username = ?";
	        try {
	        	
	            Query query = session.createQuery(hql);
	            query.setParameter(0, username);
	            
	            list = query.list();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        finally {
	            HibernateUtil.closeSession(session);
	        }  
	        System.out.println(list);
	        return list;
		
	}
	@Override
	public boolean excute(String hql, Object[] obj) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSession();
				session.beginTransaction();
				Query query = session.createQuery(hql);
				if (obj != null && obj.length > 0) {
					for (int i = 0; i < obj.length; i++) {
						System.out.println("idÊÇ"+obj[i]);
						query.setParameter(i, obj[i]);
					}
				}
		
				// Ö´ÐÐhqlÓï¾ä
				if (query.executeUpdate() > 0) {
					return true;

				}
				session.getTransaction().commit();
				session.clear();
				return false;
	}
}
