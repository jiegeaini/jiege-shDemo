package com.fly.music.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.fly.music.dao.UserDao;
import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;
import com.fly.music.entity.Singer;
import com.fly.music.entity.User;
import com.fly.music.impl.IUserBizImpl;
import com.fly.music.impl.IUserDaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @title 用户的业务类
 * @author 邓力凡
 *
 */
public class UserService {
	/**
	 * @title 返回当前用户喜欢的歌曲
	 * @param String user
	 * @function 根据用户名返回
	 * @return 
	 */
	public JSONArray getUserLikeMusic(String username){
		JSONArray array = new JSONArray();
		UserDao dao =  new IUserDaoImpl();
		List list = dao.getUser(username);
		Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			User user = (User) iter.next();
			Set<Music> set = user.getMusics();
			Iterator<Music> iterm = set.iterator();
			while (iterm.hasNext()) {
				JSONObject json = new JSONObject();
				Music music = (Music) iterm.next();
				json.put("id", music.getId());
				json.put("name", music.getName());
				json.put("singername", music.getSinger().getName());
				json.put("img", music.getSinger().getSmallImg());
				array.add(json);
				
			}
			
		}
		return array;
		
	}
	
	/**
	 * @title 返回当前用户喜欢的歌手
	 * @param String user
	 * @function 根据用户名返回
	 * @return 
	 */
	public JSONArray getUserLikesiger(String username){
		
		JSONArray array = new JSONArray();
		UserDao dao =  new IUserDaoImpl();
		List list = dao.getUser(username);
		Iterator<User> iter = list.iterator();
		
		while (iter.hasNext()) {
			User user = (User) iter.next();
			Set<Singer> set1 = user.getSingers();
			Iterator<Singer> iterm = set1.iterator();
			while (iterm.hasNext()) {			
				JSONObject json = new JSONObject();
				Singer singer = (Singer) iterm.next();
				json.put("id", singer.getId());
				json.put("img", singer.getSmallImg());
				json.put("name", singer.getName());
				json.put("where", singer.getCountries());
				array.add(json);
			}
			
		}
		return array;
		
	}
	
	/**
	 * @title 返回当前用户喜欢的歌手
	 * @param String user
	 * @function 根据用户名返回
	 * @return 
	 */
	
	
	public JSONArray getUserLikemusicpage(String username){
		System.out.println("dasdasdasdasdadasd");
		JSONArray array = new JSONArray();
		UserDao dao =  new IUserDaoImpl();
		List list = dao.getUser(username);
		Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			User user = (User) iter.next();
			Set<Musicpage> set2 = user.getMmusicpages();
			
			Iterator<Musicpage> iterm = set2.iterator();
			
			while(iterm.hasNext()) {
				JSONObject json = new JSONObject();
				Musicpage musicpage = (Musicpage) iterm.next();
				
				json.put("id", musicpage.getId());
				json.put("name", musicpage.getName());
				json.put("upold", musicpage.getUser().getUsername());
				json.put("img", musicpage.getBigImg());
				array.add(json);
				
			}
		}
		
		
		
		return array;
		
	
		
	}
	
	public JSONArray getUserName(String username){
		JSONArray array = new JSONArray();
		UserDao dao =  new IUserDaoImpl();
		List list = dao.getUser(username);
		Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			JSONObject json = new JSONObject();
			User user = (User) iter.next();
			json.put("username",user.getUsername());
			json.put("phone",user.getPassword());
			array.add(json);
		}
		
		return array;
	}
	
	@Test
	public void a(){
		UserService u = new UserService();
		System.out.println(u.getUserName("小光").size());
	}
}
