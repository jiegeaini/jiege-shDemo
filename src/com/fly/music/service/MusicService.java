package com.fly.music.service;

import java.util.Iterator;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.fly.music.dao.DBDao;
import com.fly.music.dao.MusicDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;
import com.fly.music.entity.Singer;
import com.fly.music.impl.DBDaoImpl;
import com.fly.music.impl.IMusicDaoImpl;
import com.fly.music.util.HibernateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 歌曲的业务类
 * @author jiege
 *
 */
public class MusicService {
	/**
	 * @title 用来将查询到的歌单list转换为jsonarray
	 * @function 转换后不添加歌曲
	 * @param list
	 * @return
	 */
	public JSONArray setList_Json(List<Musicpage> list) {
		JSONArray array = new JSONArray();
		Iterator<Musicpage> iterator = list.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = new JSONObject();
			Musicpage musicpage = (Musicpage) iterator.next();
			jsonObject.put("id", musicpage.getId());
			jsonObject.put("name", musicpage.getName());
			jsonObject.put("username", musicpage.getUser().getUsername());
			jsonObject.put("img", musicpage.getBigImg());
			array.add(jsonObject);
		}
		return array;
	}
	/**
	 * @title 用来将查询到的歌曲list转换为jsonarray
	 * @function 转换后不添加其它关联表
	 * @param list
	 * @return
	 */
	public JSONArray setListMusic_Json(List<Music> list) {
		JSONArray array = new JSONArray();
		Iterator<Music> iterator = list.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = new JSONObject();
			Music music = (Music) iterator.next();
			jsonObject.put("id", music.getId());
			jsonObject.put("name", music.getName());
			jsonObject.put("singerName", music.getSinger().getName());
			jsonObject.put("img", music.getSinger().getSmallImg());
			array.add(jsonObject);
		}
		return array;
	}
	/**
	 * @title 返回歌单所对应的歌曲
	 * @function 不添加其它关联表
	 * @param int
	 * @return
	 */
	public JSONArray getMusicpageMusic(int id) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		DBDao dbDao = new  DBDaoImpl();
		try {
			Musicpage page = (Musicpage) dbDao.getObject(id, Musicpage.class);
			System.out.println(page.getName());
			Set<Music> set = page.getMusics();
			Iterator<Music> iterator = set.iterator();
			while (iterator.hasNext()) {
				Music music = (Music) iterator.next();
				jsonObject.put("id", music.getId());
				jsonObject.put("name", music.getName());
				jsonObject.put("img", page.getBigImg());
				jArray.add(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jArray;
	}
	/**
	 * @title 返回根据id查询的歌曲
	 * @function 不添加其它关联表
	 * @param int
	 * @return
	 */
	public JSONObject getMusicMess(int id) {
		DBDao dao = new DBDaoImpl();
		JSONObject jsonObject = new JSONObject();
		try {
			Music music = (Music) dao.getObject(id, Music.class);
			jsonObject.put("mp3", music.getPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * @title 是否有当前歌手
	 * @function 不添加其它关联表，根据歌手名字操作
	 * @param String
	 * @return
	 */
	public boolean getMusicSingerMess(String name) {
		Session session = HibernateUtil.getSession();
		String hql = "from Singer where name = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		@SuppressWarnings("unchecked")
		List<Singer> list = query.list();
		Iterator<Singer> iterator = list.iterator();
		if (iterator.hasNext()) {
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	/**
	 * @title 查询当前歌手ID
	 * @function 不添加其它关联表，根据歌手名字操作
	 * @param String
	 * @return
	 */
	public int getSingerId(String name) {
		int id = 0;
		Session session = HibernateUtil.getSession();
		String hql = "from Singer where name = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, name);
		@SuppressWarnings("unchecked")
		List<Singer> list = query.list();
		Iterator<Singer> iterator = list.iterator();
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				Singer singer = (Singer) iterator.next();
				id = singer.getId();
			}
		}
		session.close();
		return id;
	}
	/**
	 * @title 返回音乐数据
	 * @return
	 */
	public JSONArray getMusicMessage(int currentPage,int pageSize) {
		JSONArray array = new JSONArray();
		Session session = HibernateUtil.getSession();
		int beginIndex=(currentPage-1)*pageSize;//起始索引
		Query query=session.createQuery("from Music");
		query.setFirstResult(beginIndex);//起始索引
		query.setMaxResults(pageSize);//显示的数据行数
		@SuppressWarnings("unchecked")
		List<Music> list = query.list();
		Iterator<Music> iterator = list.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = new JSONObject();
			Music music = (Music) iterator.next();
			jsonObject.put("id", music.getId());
			jsonObject.put("name", music.getName());
			jsonObject.put("music", music.getPath());
			jsonObject.put("singer", music.getSinger().getName());
			array.add(jsonObject);
		}
		session.close();
		return array;

	}
	/**
	 * @title 获取music总页数
	 * @return
	 */
	public int getMusicMax(){
		int count=0;
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Music> list=session.createQuery("from Music").list();
		count=list.size();
		if (count % 6 != 0) {
			return (int)count/6+1; 
		}
		return count/6;
		
		}


	@Test
	public void test() {
		System.out.println(getMusicMax());
	}
}
