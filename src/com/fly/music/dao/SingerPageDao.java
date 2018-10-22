package com.fly.music.dao;

import java.util.List;

import com.fly.music.entity.Singer;

/**
 * @author ����
 * @author mrc
 *
 */
public interface SingerPageDao {
    /**
     * ��ȡ���ҳ��
     * @return
     * @throws Exception
     */
    Integer getMaxPage() throws Exception;

    Integer getPageNumber() throws Exception;

    List<Singer> getSingerpage(int num) throws Exception;

}
