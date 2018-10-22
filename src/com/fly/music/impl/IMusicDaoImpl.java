package com.fly.music.impl;

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
import com.fly.music.util.HibernateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * @title MusicDao��ʵ����
 * @author jiege
 * @param <T>
 *
 */
public class IMusicDaoImpl implements MusicDao{

	/**
	 * @title ֻ��ȡ���µ�5���赥
	 * @throws Exception
	 */
	@Override
	public List<Musicpage> getMusicPage() throws Exception {
		int max = getMax("Musicpage");
		Session	Session = HibernateUtil.getSession();
		String hql = "from Musicpage where id > ? and id <= ?";
		Query query = Session.createQuery(hql);
		query.setParameter(0, max-5);
		query.setParameter(1, max);
		@SuppressWarnings("unchecked")
		List<Musicpage> list = query.list();
		HibernateUtil.closeSession(Session);
		return list;
	}



	/**
	 * ��ѯ����������
	 * @param <T>
	 */
	public <T>Integer getMax(String className) {
		int max = 0;
		Session	Session = HibernateUtil.getSession();
		String sql = "select max(id) max from "+className+"";
		Query query = Session.createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Integer> list = query.list();
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			max = integer;
		}
		HibernateUtil.closeSession(Session);
		return max;
	}

	@Test
	public void test() {
		try {
			System.out.println(getMusic());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @title ֻ��ȡ���µ�15��������
	 * @throws Exception
	 */
	@Override
	public List<Music> getMusic() throws Exception {
		int max = getMax("Music");
		Session	Session = HibernateUtil.getSession();
		String hql = "from Music where id > ? and id <= ?";
		Query query = Session.createQuery(hql);
		query.setParameter(0, max-15);
		query.setParameter(1, max);
		@SuppressWarnings("unchecked")
		List<Music> list = query.list();
		HibernateUtil.closeSession(Session);
		return list;
	}


	/**
	 * @title ����ͨ��id��ѯ�ĸ�����Ϣ
	 * @param id
	 * @return name singername
	 */
	@Override
	public JSONObject getMusicObject(int id) {
		JSONObject jsonObject = new JSONObject();
		DBDao dao = new DBDaoImpl();
		try {
			Music music = (Music) dao.getObject(id, Music.class);
			jsonObject.put("name", music.getName());
			jsonObject.put("singername", music.getSinger().getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * @title ����ͨ������id��ѯ�ĸ�����Ϣ
	 */
	@Override
	public JSONArray getSingerMusic(int id) {
		JSONArray array = new JSONArray();
		DBDao dao = new DBDaoImpl();
		try {
			Singer singer = (Singer) dao.getObject(id, Singer.class);
			Set<Music> set = singer.getMusics();
			Iterator<Music> iterator = set.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject = new JSONObject();
				Music music = (Music) iterator.next();
				jsonObject.put("id", music.getId());
				jsonObject.put("name", music.getName());
				jsonObject.put("img", singer.getBigImg());
				array.add(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
		
	}



	@Override
	public JSONObject getMusicObjectC(int id) {
		JSONObject jsonObject = new JSONObject();
		DBDao dao = new DBDaoImpl();
		try {
			Music music = (Music) dao.getObject(id, Music.class);
			jsonObject.put("id", music.getId());
			jsonObject.put("name", music.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
}
