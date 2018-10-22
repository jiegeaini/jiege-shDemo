package com.fly.music.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @title 用于连接hibernate的工具类
 * @author Administrator
 *  
 */
public class HibernateUtil {
    
    //Hibernate 的初始化. -〉创建SessionFactory
    private static SessionFactory sessionFactory;
    //创建session对象
    private static Session session;
    
    static{
        //读取 cfg文件
        Configuration cd=new Configuration().configure();   
        //读取Hibernate 的配置信息
         sessionFactory=cd.buildSessionFactory();
    }
    
    public static Session getSession(){
        
       //打开事物，返回session
       session = sessionFactory.openSession();
       return session;
    }
    
    public static void closeSession(Session session){
        
        //关闭事物
        if (session != null) {
           session.close(); 
        }
    }
}
