package com.fly.music.service;

import java.util.List;
import java.util.Set;

import com.fly.music.entity.Singer;
import com.fly.music.entity.SingerF;

import net.sf.json.JSONArray;

/**
 * 将一对多里面取出的set集合遍历转换为Json
 * 
 * @author mrc
 *
 */
public class SingerJSON {

    /**
     * 将singer对象里面的单独属性取出来构成对象
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
        /** 封装有用的数据 */
        JSONArray json = new JSONArray();

        for (Singer singer : list) {
            SingerF singerf = new SingerF(singer.getId(), singer.getName(), singer.getSmallImg(), singer.getBigImg(),
                    singer.getCountries(), singer.getSingercategory().getName());
            json.add(singerf);
        }
        return json;
    }
}
