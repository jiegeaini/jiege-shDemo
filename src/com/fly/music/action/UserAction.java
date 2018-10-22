package com.fly.music.action;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.fly.music.dao.UserBiz;
import com.fly.music.entity.User;
import com.fly.music.impl.DBDaoImpl;
import com.fly.music.impl.IUserBizImpl;
import com.fly.music.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @title 判断登录 注册
 * @author 邓力凡
 *
 */
public class UserAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String phone;
	
	

	@Override
	public String execute() throws Exception {
		JSONObject json = new JSONObject();
		UserBiz<?> biz = new IUserBizImpl();
		HttpServletResponse resp  = ServletActionContext.getResponse();
		System.out.println("haha");
		PrintWriter out=resp.getWriter();	
    	resp.setContentType("text/html;charset=utf-8");
	
	
		if(biz.islogin(username,password)){
			System.out.println("action掉业务逻辑层");
			ActionContext.getContext().getSession().put("user", username);
			System.out.println(biz.islogin(username,password));
			json.put("mess", "ok");
			out.print(json);
			return null;
		}
		json.put("mess", "notok");
			out.print(json);
			return null;
	}
	
	public String signupAction() throws IOException{
		
		System.out.println("进入注册add");
		UserBiz<?> biz = new IUserBizImpl();
		HttpServletResponse resp  = ServletActionContext.getResponse();
		System.out.println("haha");
		PrintWriter out=resp.getWriter();	
    	resp.setContentType("text/html;charset=utf-8");
    	
    	if(biz.islogin(username)==false){
    		JSONObject json = new JSONObject();
    		json.put("success", "notok");   		
    		out.print(json);
    		return null;
    	}
    		User user = new User();
    		user.setUsername(username);
        	user.setPassword(password);
        	user.setPhone(phone);
        	DBDaoImpl dbd = new DBDaoImpl();
        	dbd.getAllObject(username);
        	dbd.addObject(user);
        	JSONObject json = new JSONObject();
    		json.put("success", "ok");   		
    		out.print(json);
    		return null;
    
	}
	
	/**
	 * 查询用户喜欢的歌曲
	 * @throws IOException 
	 */
	public void likemusic() throws Exception{
		UserService user = new UserService();
		JSONArray array = user.getUserLikeMusic((String)ServletActionContext.getRequest().getSession().getAttribute("user"));
		HttpServletResponse resp  = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();	
		System.out.println(array);
		out.print(array);
		
	}
	/**
	 * 查询用户喜欢的歌手
	 * @return
	 * @throws IOException 
	 */
	
	public void likesiger() throws Exception{
		UserService user = new UserService();
		JSONArray array = user.getUserLikesiger((String)ServletActionContext.getRequest().getSession().getAttribute("user"));
		HttpServletResponse resp  = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();	
		System.out.println(array);
		out.print(array);
	}
	
	/**
	 * 查询用户喜欢的歌单
	 * @return
	 * @throws IOException 
	 */
	public void likemusicpage() throws Exception{
		UserService user = new UserService();
		JSONArray array = user.getUserLikemusicpage((String)ServletActionContext.getRequest().getSession().getAttribute("user"));
		HttpServletResponse resp  = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();	
		
		out.print(array);
	}
		
	/**
	 * 返回一个用户名
	 * @return
	 * @throws Exception 
	 */
	
	
	public void username() throws Exception{
		UserService user = new UserService();
		HttpServletResponse resp  = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();	
		JSONArray array = user.getUserName((String)ServletActionContext.getRequest().getSession().getAttribute("user"));
		System.out.println("用户名"+array);
		out.print(array);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
