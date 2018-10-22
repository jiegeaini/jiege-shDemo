package com.fly.music.util;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;

import org.junit.Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title json的数据转换工具包
 * @author Administrator
 * @created 2018-10-11 8:29
 */
public class JsonUtil {
    /**
     * @title 用来转换json
     * @function 将传来的map集合或对象转换为json
     * @param object
     * @return
     */
    public static JSONObject toJson(Object object){
      JSONObject jsonObject = new JSONObject();
      jsonObject = JSONObject.fromObject(object);
      return jsonObject;
    }
    /**
     * @title 用来转换jsonArray
     * @function 将传来的list集合转换为jsonArray
     * @param object
     * @return
     */
    public static JSONArray toJsonArray(Object object){
        JSONArray array = new JSONArray();
        array = JSONArray.fromObject(object);
        return array;
    }
    @Test
    public void test(){
//        List<Map<String, String>> list = new ArrayList<Map<String,String>>();
//        for(int i = 0; i<3;i++){
//            Map<String, String> map = new HashMap<>();
//            map.put("1", "zh");
//            map.put("2", "jiege"); 
//            list.add(map);
//        }
//          JSONArray array = toJsonArray(list);
//          @SuppressWarnings("unchecked")
//        Iterator<Map<String, String>> iter = array.iterator();
//          while (iter.hasNext()) {
//            Map<String,String> map = 
//                    (Map<String,String>) iter.next();
//            Set<String> set = map.keySet();
//            Iterator<String> iterator1 =  set.iterator();
//            while (iterator1.hasNext()) {
//                String string = (String) iterator1.next();
//                System.out.println(map.get(string));
//            }
//        }
    }
}
