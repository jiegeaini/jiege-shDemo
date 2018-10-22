package com.fly.music.dao;

import java.util.List;


import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * @title 歌曲的数据接口
 * @author jiege
 *
 */
public interface MusicDao {
	/**
	 * @title 只获取最新的5条歌单
	 * @throws Exception
	 */
	List<Musicpage> getMusicPage()throws Exception;
	/**
	 * @title 只获取最新的15首条歌曲
	 * @throws Exception
	 */
	List<Music> getMusic()throws Exception;
	
	/**
	 * @title 返回通过id查询的歌曲信息
	 */
	JSONObject getMusicObject(int id);
	/**
	 * @title 返回根据歌手id查询到的歌曲
	 */
	JSONArray getSingerMusic(int id);
	/**
	 * @title 返回通过传来的歌曲id查询的歌曲信息
	 */
	JSONObject getMusicObjectC(int id);
}
