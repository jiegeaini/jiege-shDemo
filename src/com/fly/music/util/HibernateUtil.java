package com.fly.music.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @title ��������hibernate�Ĺ�����
 * @author Administrator
 *  
 */
public class HibernateUtil {
    
    //Hibernate �ĳ�ʼ��. -������SessionFactory
    private static SessionFactory sessionFactory;
    //����session����
    private static Session session;
    
    static{
        //��ȡ cfg�ļ�
        Configuration cd=new Configuration().configure();   
        //��ȡHibernate ��������Ϣ
         sessionFactory=cd.buildSessionFactory();
    }
    
    public static Session getSession(){
        
       //���������session
       session = sessionFactory.openSession();
       return session;
    }
    
    public static void closeSession(Session session){
        
        //�ر�����
        if (session != null) {
           session.close(); 
        }
    }
}
