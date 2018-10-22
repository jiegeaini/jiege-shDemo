package com.fly.music.dao;

import java.util.List;



/**
 * ÒµÎñÂß¼­²ã
 * @author Lenovo
 *
 */

public interface UserBiz<T> {
	
	/**
	 * ÅÐ¶ÏµÇÂ¼
	 * @param loginbean
	 * @return 
	 */
	public boolean islogin(String username,String password);
	public boolean islogin(String username);
	
}	
