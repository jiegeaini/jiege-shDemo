package com.fly.music.dao;

import java.util.List;


/**
 * @title ���ݿ�ļ򵥵�ʵ����
 * @author Administrator
 * @function ���ڲ������ŵ����з���
 */
public interface DBDao {
    /**
     * @title ������Ӷ���
     * @function �Ѵ����Ķ�����б���
     * @param object
     * @throws Exception
     */
    void addObject(Object object)throws Exception;
    /**
     * @param <T>
     * @title ���ڶ�������в�ѯ
     * @function ��ѯ���ж�������
     * @return
     * @throws Exception
     */
    <T> List<T> getAllObject(String class1)throws Exception;
    /**
     * @param news
     * @title ���ڶ����ɾ��
     * @function ���ݶ�����ɾ������
     * @throws Exception
     */
    void deleteObject(Object object)throws Exception;
    /**
     * @param <T>
     * @title ���ڶ���Ĳ�ѯ
     * @function ����id����ѯ��Ӧ�Ķ���
     * @throws Exception
     * @return
     */
    <T> Object getObject(int id,Class<T> class1)throws Exception;
    /**
     * @title ���ڶ�����޸�
     * @function ���ݶ������޸Ķ���
     * @throws Exception
     * @param object
     */
    void updateObject(Object object)throws Exception;
    
}
