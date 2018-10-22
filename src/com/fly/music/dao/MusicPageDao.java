package com.fly.music.dao;

import java.util.List;

import com.fly.music.entity.Musicpage;

/**
 * @title �����赥�Ľӿ���
 * @author ����
 * @function ���ڲ����赥�����з���
 */
public interface MusicPageDao {
    
    /**
     * @param <T>
     * @title ���ڸ赥����Ĳ�ѯ
     * @function ���ظ赥����
     * @return
     * @throws Exception
     */
    Integer getMaxPage() throws Exception;
    
    /**
     * @param <T>
     * @title ���ڸ赥��ҳ�����Ĳ���
     * @function ���ط�ҳҳ��
     * @return
     * @throws Exception
     */
    Integer getPageNumber() throws Exception;
    
    /**
     * @param <T>
     * @title �����޸ķ�ҳ�����Ĳ���
     * @function ���ط�ҳҳ��
     * @return
     * @throws Exception
     */
    Integer getUpdateNumber() throws Exception;
    
    /**
     * @title �������ز���ĸ赥��Ϣ
     * @function ͨ��ID�����в�ѯ
     * @param num
     * @return
     * @throws Exception
     */
    List<Musicpage> getMusicpage(int num)throws Exception;
    
    /**
     * @title �������ز���ĸ赥��Ϣ���޸�ҳ�棩
     * @function ͨ���ڼ�ҳ�����в�ѯ
     * @param num
     * @return
     * @throws Exception
     */
    public List<Musicpage> getUpdatePage(int x) throws Exception;
}
