package com.fly.music.dao;

import java.util.List;

public interface UserDao<T> {
	public List<T> getUser(String username,String password);
	public List<T> getUser(String username);
	public boolean excute(String hql,Object[] obj);
	
}
