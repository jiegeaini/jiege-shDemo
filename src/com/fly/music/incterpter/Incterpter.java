package com.fly.music.incterpter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Incterpter implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//运行的action的名字
		String actionName = invocation.getAction().getClass().getName();	
		//执行的action的方法
		String method = invocation.getProxy().getMethod();
		System.out.println(actionName+"的"+method+"方法开始执行");
		invocation.invoke();
		return null;
	}

}
