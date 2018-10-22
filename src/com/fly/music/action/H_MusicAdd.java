package com.fly.music.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fly.music.dao.DBDao;
import com.fly.music.dao.MusicDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Singer;
import com.fly.music.impl.DBDaoImpl;
import com.fly.music.impl.IMusicDaoImpl;
import com.fly.music.service.MusicService;
import com.fly.music.util.Base64Upload;
import com.fly.music.util.Upload;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title ���������û���ҳ���ݷ��صĽӿ�
 * @author jiege
 *
 */
public class H_MusicAdd extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**��ǰ��ҳ��*/
	private String count;
	private String id;
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		  HttpServletResponse response =  ServletActionContext.getResponse();
		  response.setContentType("text/html;charset=utf-8");
		  JSONObject jsonObject = new JSONObject();
		MusicService service = new MusicService();
		int max = service.getMusicMax();
		jsonObject.put("max", max);
		response.getWriter().println(jsonObject);
		return null;
	}
	/**
	 * @title ����ҳ�洫����ֵ���з�������
	 */
	public void zhi() {
		HttpServletResponse response =  ServletActionContext.getResponse();
		  response.setContentType("text/html;charset=utf-8");
		  JSONArray array = new JSONArray();
		  MusicService service = new MusicService();
		  array = service.getMusicMessage(Integer.parseInt(count), 6);
		  try {
			response.getWriter().println(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @title ����ҳ�洫����ֵ�������ݸ���
	 */
	public void update() {
		HttpServletResponse response =  ServletActionContext.getResponse();
		  response.setContentType("text/html;charset=utf-8");
		  JSONArray array = new JSONArray();
		  MusicService service = new MusicService();
		  array = service.getMusicMessage(Integer.parseInt(count), 6);
		  try {
			response.getWriter().println(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @title ����ҳ�洫����id��ȡ������Ϣ
	 */
	public void getMusic() {
		HttpServletResponse response =  ServletActionContext.getResponse();
		  response.setContentType("text/html;charset=utf-8");
		  JSONObject object = new JSONObject();
		 MusicDao dao = new IMusicDaoImpl();
		 object = dao.getMusicObject(Integer.parseInt(id));
		  try {
			response.getWriter().println(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @title ����ҳ�洫����idɾ��������Ϣ
	 */
	public void delete() {
		HttpServletResponse response =  ServletActionContext.getResponse();
		  response.setContentType("text/html;charset=utf-8");
		  JSONObject object = new JSONObject();
		  DBDao dao = new DBDaoImpl();
		 Music music;
		try {
			music = (Music) dao.getObject(Integer.parseInt(id), Music.class);
			 dao.deleteObject(music);
			 object.put("mess", "ɾ���ɹ�");
			 response.getWriter().println(object);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 object.put("mess", "ɾ��ʧ��");
			 try {
				response.getWriter().println(object);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 object.put("mess", "ɾ��ʧ��");
			 try {
				response.getWriter().println(object);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			  
}
}
