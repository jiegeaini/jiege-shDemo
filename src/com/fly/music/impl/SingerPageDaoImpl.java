package com.fly.music.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.fly.music.dao.SingerPageDao;
import com.fly.music.entity.Singer;
import com.fly.music.util.HibernateUtil;

/**
 * 歌手页分页的划分
 * 
 * @author 17639
 *
 */
public class SingerPageDaoImpl implements SingerPageDao {

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
        String sql = "select max(id) max from singer";
        Session session = HibernateUtil.getSession();
        try {
            Query query = session.createSQLQuery(sql);
            @SuppressWarnings("unchecked")
            List<Integer> list = query.list();
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer integer = (Integer) iterator.next();
                maxId = integer;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtil.closeSession(session);
        }
        return maxId;
    }

    @Override
    public Integer getPageNumber() throws Exception {
        // 每页显示的数据条数
        int pageSize = 6;
        // 总的数据条数
        int totalRecord = getMaxPage();
        // 定义一个变量用于接收分页的页数
        int totalPage = 0;

        if (totalRecord % pageSize == 0) {

            // 说明整除，每页显示pageSize条数据
            totalPage = totalRecord / pageSize;

        } else {

            // 不整除，就要加一页，显示多余的数据

            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }

    /**
     * 这边选取的是Singer表
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Singer> getSingerpage(int num) throws Exception {
        int max = getPageNumber();// 最大页数
        int pageSize = 6;//页面大小
        List<Singer> list = null;
        if (num <= max) {
            //必须小于最大页数
            int start = (num - 1) * pageSize;// 起始值
            int end = start + pageSize;// 结束值
            Session session = HibernateUtil.getSession();
            String hql = "from Singer where id > ? and id <= ?";
            Query query = session.createQuery(hql);
            query.setParameter(0, start);
            query.setParameter(1, end);
            list = query.list();
            session.close();
        }

        return list;
        // SUCCESS
    }

    @Test
    public void test() throws Exception {
        System.out.println(getSingerpage(1).toString());
    }

}
