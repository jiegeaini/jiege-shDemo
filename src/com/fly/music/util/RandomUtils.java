package com.fly.music.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;



public class RandomUtils {
    /**
     * 随机产生指定长度的字母的字符串
     *  <p>emample:if length=5 return "aXndf"</p>
     *  <p>emample:if length=10 return "PdafXanzdf"</p>
     * @param length
     * @return
     */
    public static String getRandomLetters(int length){
      
    	StringBuffer sb = new StringBuffer();
    	
    	for (int i = 0; i < length; i++) {
    		int zhi = new Random().nextInt(9);
    		sb.append(Integer.toString(zhi));
		}
       
  return  sb.toString();

    }
    
    
    private static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(32);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
    private static String getMD51(String str) {
    	
    	
    	String string = DigestUtils.md5Hex(str);
    	
    	return string;
    }
//    8695941c45f3a8584fb5ca56600ee164
 
   @Test
   public void Test() {
	   	System.out.println(	passwordMd5("3245343"));
   }
   
   public static String passwordMd5(String pw) {
	   String md5PW = RandomUtils.getMD5(pw);
	   StringBuffer sb = new StringBuffer(pw);
	   sb.reverse();
	   sb.append(md5PW);
	 return  RandomUtils.getMD51(sb.toString());
   }
  
}
