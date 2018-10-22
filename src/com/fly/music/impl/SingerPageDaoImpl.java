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
 * ����ҳ��ҳ�Ļ���
 * 
 * @author 17639
 *
 */
public class SingerPageDaoImpl implements SingerPageDao {

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
        // ÿҳ��ʾ����������
        int pageSize = 6;
        // �ܵ���������
        int totalRecord = getMaxPage();
        // ����һ���������ڽ��շ�ҳ��ҳ��
        int totalPage = 0;

        if (totalRecord % pageSize == 0) {

            // ˵��������ÿҳ��ʾpageSize������
            totalPage = totalRecord / pageSize;

        } else {

            // ����������Ҫ��һҳ����ʾ���������

            totalPage = totalRecord / pageSize + 1;
        }
        return totalPage;
    }

    /**
     * ���ѡȡ����Singer��
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Singer> getSingerpage(int num) throws Exception {
        int max = getPageNumber();// ���ҳ��
        int pageSize = 6;//ҳ���С
        List<Singer> list = null;
        if (num <= max) {
            //����С�����ҳ��
            int start = (num - 1) * pageSize;// ��ʼֵ
            int end = start + pageSize;// ����ֵ
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
