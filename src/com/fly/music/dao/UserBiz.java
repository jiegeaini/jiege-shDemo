package com.fly.music.dao;

import java.util.List;



/**
 * ҵ���߼���
 * @author Lenovo
 *
 */

public interface UserBiz<T> {
	
	/**
	 * �жϵ�¼
	 * @param loginbean
	 * @return 
	 */
	public boolean islogin(String username,String password);
	public boolean islogin(String username);
	
}	
