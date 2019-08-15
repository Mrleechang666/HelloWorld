package cn.zl.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {

	/*
	 * ����һ��������,ȥʵ��InvocationHandler�ӿ�,������д�ýӿڵķ���
	 * �ڶ���:����һ��Ŀ���������,��߶���Ŀ����ΪObject��
	 * ������:��һ���޲ι���
	 * ���Ĳ�:дһ����̬�ķ���һ��Object�ķ���,���Ҵ������,����һ��UserProxy����,��obj��ֵ��realObj
	 * ���岽:����д�ķ�����������������,��method����invoke����,��obj��args��������,����һ��Object���͵�
	 * 
	 * 
	 */
	
	
	
	
	private Object obj;
	
	private UserProxy() {
		
	}
	
	
	public static Object newInstance(Object realObj) {
		UserProxy proxy = new UserProxy();
		proxy.obj = realObj;
		return Proxy.newProxyInstance(realObj.getClass().getClassLoader(), realObj.getClass().getInterfaces(), proxy);
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws Throwable {
		System.out.println("1.׼������..");
		Object result = method.invoke(obj, args);
		System.out.println("3,��β����");
		return result;
	}

}
