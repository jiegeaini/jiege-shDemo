package com.fly.music.dao;

import java.util.List;


import com.fly.music.entity.Music;
import com.fly.music.entity.Musicpage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



/**
 * @title ���������ݽӿ�
 * @author jiege
 *
 */
public interface MusicDao {
	/**
	 * @title ֻ��ȡ���µ�5���赥
	 * @throws Exception
	 */
	List<Musicpage> getMusicPage()throws Exception;
	/**
	 * @title ֻ��ȡ���µ�15��������
	 * @throws Exception
	 */
	List<Music> getMusic()throws Exception;
	
	/**
	 * @title ����ͨ��id��ѯ�ĸ�����Ϣ
	 */
	JSONObject getMusicObject(int id);
	/**
	 * @title ���ظ��ݸ���id��ѯ���ĸ���
	 */
	JSONArray getSingerMusic(int id);
	/**
	 * @title ����ͨ�������ĸ���id��ѯ�ĸ�����Ϣ
	 */
	JSONObject getMusicObjectC(int id);
}
