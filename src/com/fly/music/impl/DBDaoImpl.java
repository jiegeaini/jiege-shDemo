package com.fly.music.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fly.music.dao.DBDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;
import com.fly.music.entity.Singer;
import com.fly.music.entity.User;
import com.fly.music.util.HibernateUtil;

public class DBDaoImpl implements DBDao{
    /**
     * @title ������Ӷ���
     * @function �Ѵ����Ķ�����б���
     * @param object
     * @throws Exception
     */
    @Override
    public void addObject(Object object) {
        Session session = HibernateUtil.getSession();
        Transaction ts = session.beginTransaction();
        try {
            session.save(object);
            ts.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ts.rollback();
        }
        finally {
            HibernateUtil.closeSession(session);
        }    
    }
    /**
     * @param <T>
     * @title ���ڶ�������в�ѯ
     * @function ��ѯ���ж�������
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> getAllObject(String class1) {
        List<T> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        String hql = "from "+class1+"";
        try {
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            HibernateUtil.closeSession(session);
        }    
        return list;
    }
    /**
     * @param news
     * @title ���ڶ����ɾ��
     * @function ���ݶ�����ɾ������
     * @throws Exception
     */
    @Override
    public void deleteObject(Object object) {
        Session session = HibernateUtil.getSession();
        Transaction ts = session.beginTransaction();
        try {
            session.delete(object);
            ts.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ts.rollback();
        }
        finally {
            HibernateUtil.closeSession(session);
        }        
    }
    /**
     * @param <T>
     * @title ���ڶ���Ĳ�ѯ
     * @function ����id����ѯ��Ӧ�Ķ���
     * @throws Exception
     * @return
     */
    @Override
    public<T> Object getObject(int id,Class<T> class1) {
        Session session = HibernateUtil.getSession();
        Object object = new Object();
        try {
            object = session.get(class1, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            HibernateUtil.closeSession(session);
        }    
        return object;
    }
    /**
     * @title ���ڶ�����޸�
     * @function ���ݶ������޸Ķ���
     * @throws Exception
     * @param object
     */
    @Override
    public void updateObject(Object object) {
        Session session = HibernateUtil.getSession();
        Transaction ts = session.beginTransaction();
        try {
            session.update(object);
            ts.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ts.rollback();
        }
        finally {
            HibernateUtil.closeSession(session);
        }     
    }

    /**
     * @param <T>
     * @title ��Ԫ����
     * @function �������Բ�ѯ�����û���Ϣ
     */
    @Test
    public <T> void test() {
    	List<T> list = getAllObject("User");
    	Iterator<T> iterator = list.iterator();
    	while (iterator.hasNext()) {
			User user = (User) iterator.next();
			System.out.println(user.getId());
			System.out.println(user.getImg());
			System.out.println(user.getPassword());
			System.out.println(user.getPath());
			System.out.println(user.getPhone());
			System.out.println(user.getUsername());
			
			System.out.println("----------------");
			//Ϊ��ϲ���ĸ���
			Iterator<Singer> iterator2 = user.getSingers().iterator();
			while (iterator2.hasNext()) {
				Singer singer = (Singer) iterator2.next();
				System.out.println(singer.getName());
			}
			//Ϊ�ҷ����ĸ赥
			Iterator<Musicpage> iterator3 = user.getMmusicpages().iterator();
			while (iterator3.hasNext()) {
				Musicpage musicpage = (Musicpage) iterator3.next();
				System.out.println(musicpage.getName());
			}
			//Ϊ��ϲ���ĸ赥
			Iterator<Musicpage> iterator4 = user.getMusicpages().iterator();
			while (iterator4.hasNext()) {
				Musicpage musicpage = (Musicpage) iterator4.next();
				System.out.println(musicpage.getName());
				
			}
			//Ϊ��ϲ���ĸ���
			Iterator<Music> iterator5 = user.getMusics().iterator();
			while (iterator5.hasNext()) {
				Music music = (Music) iterator5.next();
				System.out.println(music.getName());
				
			}
		}
    }
    }
