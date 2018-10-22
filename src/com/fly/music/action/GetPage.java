package com.fly.music.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.fly.music.dao.MusicPageDao;
import com.fly.music.entity.Musicpage;
import com.fly.music.impl.MusicPageDaoImpl;
import com.fly.music.service.MusicpageService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title �����赥��Action��
 * @author ����
 * @function ������ǰ̨���ظ赥��Ϣ
 */
public class GetPage extends ActionSupport{
    private int x;
    private int num;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @title ����赥ҳ��Ӧ�÷ּ�ҳ
     * @return
     */
   public String getPageNum(){
       JSONObject jsonObject = new JSONObject();
       int num = 0;
       HttpServletResponse response = ServletActionContext.getResponse();
       response.setContentType("text/html;charset=utf-8");
       MusicPageDao dao = new MusicPageDaoImpl();
       try {
       num = dao.getPageNumber();
       jsonObject.put("num", num);
       //�иþ���ܽ����ݴӺ�̨����ǰ̨
       response.getWriter().print(jsonObject);
       } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
       }
       return null;
   }
   
   /**
    * @title �����޸�ҳ��Ӧ�÷ּ�ҳ
    * @return
    */
  public String getUpdateNum(){
      JSONObject jsonObject = new JSONObject();
      int num = 0;
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setContentType("text/html;charset=utf-8");
      MusicPageDao dao = new MusicPageDaoImpl();
      try {
      num = dao.getUpdateNumber();
      jsonObject.put("x", num);
      //�иþ���ܽ����ݴӺ�̨����ǰ̨
      response.getWriter().print(jsonObject);
      } catch (Exception e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      }
      return null;
  }
   
   /**
    * @title ���ظ赥����Ϣ��ǰ̨
    * @return
    */
   public void getPage() {
       HttpServletResponse response = ServletActionContext.getResponse();
       response.setContentType("text/html;charset=utf-8");
       List<Musicpage> list = null;
       MusicpageService musicpageService = new MusicpageService();
       MusicPageDao dao = new MusicPageDaoImpl();
       try {
        //ǰ̨ajax��������numֵ����ǰҳ�룩
        list = dao.getMusicpage(num);
        JSONArray array = musicpageService.setlist_json(list);
        //������ݵ�ǰ̨
        response.getWriter().println(array);
       } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
       }     
   }
   
   /**
    * @title ���ظ赥����Ϣ���޸�ҳ��
    * @return
    */
   public void getUpdatePage() {
       HttpServletResponse response = ServletActionContext.getResponse();
       response.setContentType("text/html;charset=utf-8");
       List<Musicpage> list = null;
       MusicpageService musicpageService = new MusicpageService();
       MusicPageDao dao = new MusicPageDaoImpl();
       try {
        //ǰ̨ajax��������numֵ����ǰҳ�룩
        list = dao.getUpdatePage(x);
        JSONArray array = musicpageService.setlist_json(list);
        //������ݵ�ǰ̨
        response.getWriter().println(array);
       } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
       }     
   }
  
/**
 * @return the x
 */
public int getX() {
    return x;
}

/**
 * @param x the x to set
 */
public void setX(int x) {
    this.x = x;
}

/**
 * @return the num
 */
public int getNum() {
    return num;
}

/**
 * @param num the num to set
 */
public void setNum(int num) {
    this.num = num;
}
   
}
