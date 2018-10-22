package com.fly.music.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.misc.BASE64Decoder;

/**
 * ��ǰ���ϴ�������base64���н�������ͼƬ
 * @author jiege
 *
 */
public class Base64Upload {
	/**
	 * base64�ַ���ת����ͼƬ 
	 * @param imgStr
	 * imgstrΪ��ȡ����base64��
	 * @param path
	 * pathΪ��Ҫ����ͼƬ��·��
	 * @return
	 * ����ΪͼƬ������
	 */
	  public static String GenerateImage(String imgStr,String path) {  
		  //���ֽ������ַ�������Base64���벢����ͼƬ 
	    if (imgStr == null) //ͼ������Ϊ�� 
	      return "false"; 
	    BASE64Decoder decoder = new BASE64Decoder(); 
	    try { 
	      //Base64���� 
	      byte[] b = decoder.decodeBuffer(imgStr); 
	      for(int i=0;i<b.length;++i) { 
	        if(b[i]<0) {
	        //�����쳣���� 
	          b[i]+=256; 
	        } 
	      } 
	      Date date = new Date();
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
		  String as = format.format(date).toString();
	      //����jpegͼƬ 
	      String imgFilePath = path+as+".jpg";//�����ɵ�ͼƬ 
	      OutputStream out = new FileOutputStream(imgFilePath);   
	      out.write(b); 
	      out.flush(); 
	      out.close(); 
	      return as+".jpg"; 
	    }  
	    catch (Exception e)  { 
	      return "false"; 
	    } 
	  } 
	
}
