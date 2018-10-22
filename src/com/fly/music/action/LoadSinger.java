package com.fly.music.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fly.music.dao.DBDao;
import com.fly.music.entity.Singercategory;
import com.fly.music.impl.DBDaoImpl;
import com.fly.music.service.SingerJSON;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

/**
 * @author mrc
 *
 */
public class LoadSinger extends ActionSupport {

    private int id;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        /**
         * 加载歌手 按照分类加载
         * 
         * @param id
         */
        DBDao dbDao = new DBDaoImpl();
        Singercategory sing = (Singercategory) dbDao.getObject(id, Singercategory.class);
        JSONArray json = SingerJSON.toJson(sing.getSingerSet());
        
        HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html;charset=utf-8"); 
        PrintWriter pw = response.getWriter();
        pw.print(json);
        return null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
