package com.fly.music.impl;

import java.util.List;

import com.fly.music.dao.UserBiz;

import com.fly.music.entity.User;

public class IUserBizImpl implements UserBiz{

	@Override
	public boolean islogin(String username, String password) {
		// TODO Auto-generated method stub
		IUserDaoImpl<User> idao = new IUserDaoImpl<>();
		
		List list = idao.getUser(username, password);
	
		if(list.size()!=0){
			return true;
		}
		return false;
	}

	

	@Override
	public boolean islogin(String username) {
		IUserDaoImpl<User> idao = new IUserDaoImpl<>();
		
		List list = idao.getUser(username);
	
		if(list.size()!=0){
			return false;
		}
		return true;
	}
	
	
}
