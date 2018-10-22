package com.fly.music.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.fly.music.dao.MusicDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;
import com.fly.music.impl.IMusicDaoImpl;
import com.fly.music.service.MusicService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title 返回歌曲信息主页的接口
 * @author jiege
 *
 */
public class GetMusic extends ActionSupport{
	private int id;
	JSONObject jsonObject = new JSONObject();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	/**
	 * @title 返回歌单信息
	 * @return
	 */
	public String execute() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicDao musicDao = new IMusicDaoImpl();
		try {
			List<Musicpage> list = musicDao.getMusicPage();
			MusicService musicService = new MusicService();
			JSONArray array = musicService.setList_Json(list);
			response.getWriter().println(array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @title 返回歌曲信息
	 * @return
	 */
	public String getMusic() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicDao musicDao = new IMusicDaoImpl();
		try {
			List<Music> list = musicDao.getMusic();
			MusicService musicService = new MusicService();
			JSONArray array = musicService.setListMusic_Json(list);
			response.getWriter().println(array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @title 默认返回歌单歌曲信息
	 * @return
	 */
	public String getMusicpageMusic() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		IMusicDaoImpl impl = new IMusicDaoImpl();
		int max = impl.getMax("Musicpage");
		MusicService musicService = new MusicService();
		JSONArray array = musicService.getMusicpageMusic(max);
		try {
			response.getWriter().println(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @title 根据id返回歌单歌曲信息
	 * @return
	 */
	public String getMusicpageMusicId() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicService musicService = new MusicService();
		JSONArray array = musicService.getMusicpageMusic(id);
		try {
			response.getWriter().println(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @title 根据id返回歌曲信息
	 * @return
	 */
	public String getMusicID() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicService musicService = new MusicService();
		JSONObject object = musicService.getMusicMess(id);
		try {
			response.getWriter().println(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @title 根据歌手id返回歌曲信息
	 * @return
	 */
	public void getSingerMusic() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicDao dao = new IMusicDaoImpl();
		JSONArray array = dao.getSingerMusic(id);
		try {
			response.getWriter().println(array);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @title 根据传来的歌曲id返回歌曲信息
	 * @return
	 */
	public void getMusicObjectC() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		MusicDao dao = new IMusicDaoImpl();
		JSONObject jsonObject = dao.getMusicObjectC(id);
		try {
			response.getWriter().println(jsonObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
