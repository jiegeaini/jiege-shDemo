package com.fly.music.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;



public class RandomUtils {
    /**
     * �������ָ�����ȵ���ĸ���ַ���
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
            // ����һ��MD5���ܼ���ժҪ
            MessageDigest md = MessageDigest.getInstance("MD5");
            // ����md5����
            md.update(str.getBytes());
            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
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
