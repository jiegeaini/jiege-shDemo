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
		//���е�action������
		String actionName = invocation.getAction().getClass().getName();	
		//ִ�е�action�ķ���
		String method = invocation.getProxy().getMethod();
		System.out.println(actionName+"��"+method+"������ʼִ��");
		invocation.invoke();
		return null;
	}

}
