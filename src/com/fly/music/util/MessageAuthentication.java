package com.fly.music.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 短信验证工具
 * @author jiege
 *
 */
public class MessageAuthentication{
	
	/**
	 * 短信接口
	 * String number为手机号
	 * int ym为验证码
	 */
	public static void message(String number, int ym) throws Exception {
		HttpClient client = new HttpClient();  
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");   
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//头文件中转码  
		NameValuePair[] data ={ new NameValuePair("Uid", "jie哥"),new NameValuePair("Key", "d41d8cd98f00b204e980"),  
		new NameValuePair("smsMob",number),new NameValuePair("smsText","我亲爱的用户 您要注册的验证码是："+ym)};  
		post.setRequestBody(data);  
		  
		client.executeMethod(post);  
		Header[] headers = post.getResponseHeaders();  
		int statusCode = post.getStatusCode();  
		System.out.println("statusCode:"+statusCode);  
		for(Header h : headers)  
		{  
		System.out.println(h.toString());  
		}  
		String result = new String(post.getResponseBodyAsString().getBytes("gbk"));   
		System.out.println(result); //打印返回消息状态   
		post.releaseConnection();  
	}
}
