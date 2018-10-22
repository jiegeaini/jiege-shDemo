package com.fly.music.dao;

import java.util.List;

import com.fly.music.entity.Singer;

/**
 * @author 周涛
 * @author mrc
 *
 */
public interface SingerPageDao {
    /**
     * 获取最大页数
     * @return
     * @throws Exception
     */
    Integer getMaxPage() throws Exception;

    Integer getPageNumber() throws Exception;

    List<Singer> getSingerpage(int num) throws Exception;

}
