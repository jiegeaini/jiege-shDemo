package com.fly.music.service;

import java.util.List;
import java.util.Set;

import com.fly.music.entity.Singer;
import com.fly.music.entity.SingerF;

import net.sf.json.JSONArray;

/**
 * ��һ�Զ�����ȡ����set���ϱ���ת��ΪJson
 * 
 * @author mrc
 *
 */
public class SingerJSON {

    /**
     * ��singer��������ĵ�������ȡ�������ɶ���
     * 
     * @param set
     * @return
     */
    public static JSONArray toJson(Set<Singer> set) {
        JSONArray json = new JSONArray();
        for (Singer singer : set) {

            SingerF singerf = new SingerF(singer.getId(), singer.getSmallImg(), singer.getName(),
                    singer.getCountries());
            json.add(singerf);
        }

        return json;
    }

    public static JSONArray toJson(List<Singer> list) {
        /** ��װ���õ����� */
        JSONArray json = new JSONArray();

        for (Singer singer : list) {
            SingerF singerf = new SingerF(singer.getId(), singer.getName(), singer.getSmallImg(), singer.getBigImg(),
                    singer.getCountries(), singer.getSingercategory().getName());
            json.add(singerf);
        }
        return json;
    }
}
