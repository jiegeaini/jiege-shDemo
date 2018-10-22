package com.fly.music.dao;

import java.util.List;


/**
 * @title 数据库的简单的实现类
 * @author Administrator
 * @function 用于操作新闻的所有方法
 */
public interface DBDao {
    /**
     * @title 用于添加对象
     * @function 把传来的对象进行保存
     * @param object
     * @throws Exception
     */
    void addObject(Object object)throws Exception;
    /**
     * @param <T>
     * @title 用于对象的所有查询
     * @function 查询所有对象内容
     * @return
     * @throws Exception
     */
    <T> List<T> getAllObject(String class1)throws Exception;
    /**
     * @param news
     * @title 用于对象的删除
     * @function 根据对象来删除新闻
     * @throws Exception
     */
    void deleteObject(Object object)throws Exception;
    /**
     * @param <T>
     * @title 用于对象的查询
     * @function 根据id来查询相应的对象
     * @throws Exception
     * @return
     */
    <T> Object getObject(int id,Class<T> class1)throws Exception;
    /**
     * @title 用于对象的修改
     * @function 根据对象来修改对象
     * @throws Exception
     * @param object
     */
    void updateObject(Object object)throws Exception;
    
}
