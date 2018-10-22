package com.fly.music.util;

import java.io.File;

import java.io.FileOutputStream;


import javax.servlet.ServletInputStream;
/**
 * @title 上传文件的工具包
 * @author jiege
 * @created 2018-10-1 19:51
 */
public class Upload {
/**
 * @author jiege
 * @created 2018-10-1 19:51
 * @title 
 * 上传文件的方法
 * @param url
 * url为保存的地址
 * @param sin
 * sin为获取的流
 * @param Name
 * name为你想要存放文件的名称
 * @return
 * 返回文件的名称
 * @throws Exception
 */
	public static String upload(String Name,String url,ServletInputStream sin) throws Exception{
//		Date date = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd-HH-mm-ss");
//		String as = format.format(date).toString();
//		ServletInputStream sin = request.getInputStream();
		byte[] buffer = new byte[1024 * 8];
		int length = 0, row = 0;
		String mark = "";
		String filename = "";
		while ((length = sin.readLine(buffer, 0, buffer.length)) > 0) {
			System.out.println(length + "    " + new String(buffer, 0, length, "UTF-8") + "<br>");
			String s = new String(buffer, 0, length, "UTF-8");
			if (row == 0)
				mark = s.trim();
			else if (s.indexOf("filename=") > 0) {
				int end = s.lastIndexOf("\"");
				int start = s.substring(0, end).lastIndexOf("\"");
				filename = s.substring(start + 1, end);
			} else if ("".equals(s.trim()))
				break;
			row ++;
		}

		System.out.println("filename:    " + filename + "<br>");
//		String pathName = as+filename;
		int suffixDian = filename.indexOf(".");
		String suffix = filename.substring(suffixDian+1,filename.length());
		System.out.println("-----------------"+suffix);
		filename = url + Name+"."+suffix;
		FileOutputStream fout = new FileOutputStream(filename);
		while ((length = sin.readLine(buffer, 0, buffer.length)) > 0) {
			String s = new String(buffer, 0, length);
			if (s.startsWith(mark))
				break;
			fout.write(buffer, 0, length);
		}
		fout.flush();
		fout.close();
		File f = new File(filename);
		return Name+"."+suffix;
	}
//	ServletInputStream sin = request.getInputStream();
//	@SuppressWarnings("deprecation")
//	String path = request.getRealPath("/") + "../"+"images/Jvideo/tubiao/";
}
