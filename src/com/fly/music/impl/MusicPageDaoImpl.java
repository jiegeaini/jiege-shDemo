package com.fly.music.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.fly.music.dao.MusicPageDao;
import com.fly.music.entity.Musicpage;
import com.fly.music.entity.Singer;
import com.fly.music.util.HibernateUtil;

/**
 * @title �Ը赥���ݽ��з�ҳ����
 * @author ����
 * @function ���ڼ��㲢��������ķ�ҳ����
 */
public class MusicPageDaoImpl implements MusicPageDao{

    /**
     * @param <T>
     * @title ���ڸ赥����Ĳ�ѯ
     * @function ���ظ赥����
     * @return
     * @throws Exception
     */
    @Override
    public Integer getMaxPage() throws Exception {
        int maxId = 0;
        String sql = "select max(id) max from musicpage";
        Session session = HibernateUtil.getSession();
        try {
            Query query = session.createSQLQuery(sql);
            List<Integer> list = query.list();
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                Integer integer = (Integer) iterator.next();
                maxId = integer;
               }      
        }catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtil.closeSession(session);
        }
        return maxId;
    }

    /**
     * @param <T>
     * @title ���ڸ赥ҳ���ҳ�����Ĳ���
     * @function ���ط�ҳҳ��
     * @return
     * @throws Exception
     */
    @Override
    public Integer getPageNumber() throws Exception {
        //ÿҳ��ʾ����������
        int pageSize = 18;
        //�ܵ���������
        int totalRecord = getMaxPage();
        //����һ���������ڽ��շ�ҳ��ҳ��
        int totalPage = 0;
        
        if(totalRecord % pageSize == 0) {
            
            //˵��������ÿҳ��ʾpageSize������
            totalPage = totalRecord / pageSize;
            
        }else{
            
            //����������Ҫ��һҳ����ʾ���������
         
            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }
    
    /**
     * @param <T>
     * @title �����޸ķ�ҳ�����Ĳ���
     * @function ���ط�ҳҳ��
     * @return
     * @throws Exception
     */
    @Override
    public Integer getUpdateNumber() throws Exception {
        //ÿҳ��ʾ����������
        int pageSize = 6;
        //�ܵ���������
        int totalRecord = getMaxPage();
        //����һ���������ڽ��շ�ҳ��ҳ��
        int totalPage = 0;
        
        if(totalRecord % pageSize == 0) {
            
            //˵��������ÿҳ��ʾpageSize������
            totalPage = totalRecord / pageSize;
            
        }else{
            
            //����������Ҫ��һҳ����ʾ���������
         
            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title ��Ԫ����
     * @function �������Բ�ѯ�ĸ赥����
     */
    @Test
    public void test() throws Exception {
        
        System.out.println(getMaxPage());
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title ��Ԫ����
     * @function �������Լ���ķ�ҳҳ��
     */
    @Test
    public void test2() throws Exception {
        
        System.out.println(getUpdateNumber());
    }

    /**
     * @title �������ز���ĸ赥��Ϣ
     * @function ͨ���ڼ�ҳ�����в�ѯ
     * @param num
     * @return
     * @throws Exception
     */
    @Override
    public List<Musicpage> getMusicpage(int num) throws Exception {
        int max = getMaxPage();
        Session session = HibernateUtil.getSession();
        int start = 0;
        int end = 0;
        List<Musicpage> list = null;
        if (max-num*18 >= 0) {
        String hql = "from Musicpage where id > ? and id <= ?";
        start = max-num*18;
        
        if (num == 1) {
           end = max;  
        }else if (num > 1) {
           end = 18;
         }
         Query query = session.createQuery(hql);
         //��sql����еģ����ò���
         query.setParameter(0, start);
         query.setParameter(1, end);
         list = query.list();
         session.close();
         }else{
         String hql = "from Musicpage where id > ? and id <= ?";
         start = 0;
         end = max%18;
         Query query = session.createQuery(hql);
         query.setParameter(0, start);
         query.setParameter(1, end);
         list = query.list();
         session.clear();;
         }    
        return list;
    }
    
    /**
     * @title �������ز���ĸ赥��Ϣ���޸�ҳ�棩
     * @function ͨ���ڼ�ҳ�����в�ѯ
     * @param num
     * @return
     * @throws Exception
     */
    @Override
    public List<Musicpage> getUpdatePage(int x) throws Exception {
        
            int max = getUpdateNumber();// ���ҳ��
            int pageSize = 6;//ҳ���С
            List<Musicpage> list = null;
            if (x <= max) {
            //����С�����ҳ��
            int start = (x - 1) * pageSize;// ��ʼֵ
            int end = start + pageSize;// ����ֵ
            Session session = HibernateUtil.getSession();
            String hql = "from Musicpage where id > ? and id <= ?";
            Query query = session.createQuery(hql);
            query.setParameter(0, start);
            query.setParameter(1, end);
            list = query.list();
            session.close();
         }    
        return list;
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title ��Ԫ����
     * @function �������Բ�ѯ����õĸ赥ID
     */
    @Test
    public void test1(){
        try {
           List<Musicpage> list = getUpdatePage(getUpdateNumber());
           Iterator<Musicpage> iterator = list.iterator();
           while (iterator.hasNext()) {
            Musicpage musicpage = (Musicpage) iterator.next();
            System.out.println(musicpage.getId());
        }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
