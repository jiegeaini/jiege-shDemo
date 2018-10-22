package com.fly.music.service;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.fly.music.dao.MusicPageDao;
import com.fly.music.entity.Musicpage;
import com.fly.music.impl.MusicPageDaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title �����赥��ҵ���෽��
 * @author ����
 *
 */
public class MusicpageService {
    /**
     * @title �������ظ赥json
     * @function �����Ѵ����ĸ赥listת����jsonarray
     * @param list
     * @return
     */
    public JSONArray setlist_json(List<Musicpage> list){
        JSONArray jsonArray = new JSONArray();
        JSONObject jObject = new JSONObject();
        Iterator<Musicpage> iterator = list.iterator();
        while (iterator.hasNext()) {
          Musicpage musicpage = (Musicpage) iterator.next();
          jObject.put("id",musicpage.getId());
          jObject.put("name", musicpage.getName());
          jObject.put("jieshao", musicpage.getIntroduce());
          jObject.put("musicpageFID", musicpage.getMusicpagecategory().getId());
          jObject.put("userID", musicpage.getUser().getId());
          jObject.put("bigImg", musicpage.getBigImg());
          jObject.put("smallImg", musicpage.getSmallImg());
          jsonArray.add(jObject);
        }
        return jsonArray;    
    }
    
    /**
     * @param <T>
     * @throws Exception 
     * @title ��Ԫ����
     * @function ������������赥��Ϣ
     */
    @Test
    public void test(){
        MusicPageDao dao = new MusicPageDaoImpl();
        try {
            List<Musicpage> list = dao.getUpdatePage(4);
            System.out.println(setlist_json(list));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
