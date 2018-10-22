package com.fly.music.dao;

import java.util.List;

import com.fly.music.entity.Musicpage;

/**
 * @title 操作歌单的接口类
 * @author 周涛
 * @function 用于操作歌单的所有方法
 */
public interface MusicPageDao {
    
    /**
     * @param <T>
     * @title 用于歌单对象的查询
     * @function 返回歌单总数
     * @return
     * @throws Exception
     */
    Integer getMaxPage() throws Exception;
    
    /**
     * @param <T>
     * @title 用于歌单分页数量的操作
     * @function 返回分页页数
     * @return
     * @throws Exception
     */
    Integer getPageNumber() throws Exception;
    
    /**
     * @param <T>
     * @title 用于修改分页数量的操作
     * @function 返回分页页数
     * @return
     * @throws Exception
     */
    Integer getUpdateNumber() throws Exception;
    
    /**
     * @title 用来返回查出的歌单信息
     * @function 通过ID来进行查询
     * @param num
     * @return
     * @throws Exception
     */
    List<Musicpage> getMusicpage(int num)throws Exception;
    
    /**
     * @title 用来返回查出的歌单信息（修改页面）
     * @function 通过第几页来进行查询
     * @param num
     * @return
     * @throws Exception
     */
    public List<Musicpage> getUpdatePage(int x) throws Exception;
}
