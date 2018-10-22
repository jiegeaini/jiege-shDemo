package com.fly.music.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.misc.BASE64Decoder;

/**
 * 对前端上传过来的base64进行解码生成图片
 * @author jiege
 *
 */
public class Base64Upload {
	/**
	 * base64字符串转化成图片 
	 * @param imgStr
	 * imgstr为获取到的base64码
	 * @param path
	 * path为想要保存图片的路径
	 * @return
	 * 返回为图片的名字
	 */
	  public static String GenerateImage(String imgStr,String path) {  
		  //对字节数组字符串进行Base64解码并生成图片 
	    if (imgStr == null) //图像数据为空 
	      return "false"; 
	    BASE64Decoder decoder = new BASE64Decoder(); 
	    try { 
	      //Base64解码 
	      byte[] b = decoder.decodeBuffer(imgStr); 
	      for(int i=0;i<b.length;++i) { 
	        if(b[i]<0) {
	        //调整异常数据 
	          b[i]+=256; 
	        } 
	      } 
	      Date date = new Date();
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
		  String as = format.format(date).toString();
	      //生成jpeg图片 
	      String imgFilePath = path+as+".jpg";//新生成的图片 
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
