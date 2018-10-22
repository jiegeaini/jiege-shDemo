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
 * @title 对歌单数据进行分页处理
 * @author 周涛
 * @function 用于计算并返回所需的分页数据
 */
public class MusicPageDaoImpl implements MusicPageDao{

    /**
     * @param <T>
     * @title 用于歌单对象的查询
     * @function 返回歌单总数
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
     * @title 用于歌单页面分页数量的操作
     * @function 返回分页页数
     * @return
     * @throws Exception
     */
    @Override
    public Integer getPageNumber() throws Exception {
        //每页显示的数据条数
        int pageSize = 18;
        //总的数据条数
        int totalRecord = getMaxPage();
        //定义一个变量用于接收分页的页数
        int totalPage = 0;
        
        if(totalRecord % pageSize == 0) {
            
            //说明整除，每页显示pageSize条数据
            totalPage = totalRecord / pageSize;
            
        }else{
            
            //不整除，就要加一页，显示多余的数据
         
            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }
    
    /**
     * @param <T>
     * @title 用于修改分页数量的操作
     * @function 返回分页页数
     * @return
     * @throws Exception
     */
    @Override
    public Integer getUpdateNumber() throws Exception {
        //每页显示的数据条数
        int pageSize = 6;
        //总的数据条数
        int totalRecord = getMaxPage();
        //定义一个变量用于接收分页的页数
        int totalPage = 0;
        
        if(totalRecord % pageSize == 0) {
            
            //说明整除，每页显示pageSize条数据
            totalPage = totalRecord / pageSize;
            
        }else{
            
            //不整除，就要加一页，显示多余的数据
         
            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title 单元测试
     * @function 用来测试查询的歌单数量
     */
    @Test
    public void test() throws Exception {
        
        System.out.println(getMaxPage());
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title 单元测试
     * @function 用来测试计算的分页页数
     */
    @Test
    public void test2() throws Exception {
        
        System.out.println(getUpdateNumber());
    }

    /**
     * @title 用来返回查出的歌单信息
     * @function 通过第几页来进行查询
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
         //给sql语句中的？设置参数
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
     * @title 用来返回查出的歌单信息（修改页面）
     * @function 通过第几页来进行查询
     * @param num
     * @return
     * @throws Exception
     */
    @Override
    public List<Musicpage> getUpdatePage(int x) throws Exception {
        
            int max = getUpdateNumber();// 最大页数
            int pageSize = 6;//页面大小
            List<Musicpage> list = null;
            if (x <= max) {
            //必须小于最大页数
            int start = (x - 1) * pageSize;// 起始值
            int end = start + pageSize;// 结束值
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
     * @title 单元测试
     * @function 用来测试查询所获得的歌单ID
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
