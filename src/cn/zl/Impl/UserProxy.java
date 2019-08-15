package cn.zl.Impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {

	/*
	 * 创建一个代理类,去实现InvocationHandler接口,并且重写该接口的方法
	 * 第二步:创建一个目标类的属性,这边定义目标类为Object类
	 * 第三步:加一个无参构造
	 * 第四步:写一个静态的返回一个Object的方法,并且传入参数,创建一个UserProxy对象,将obj赋值给realObj
	 * 第五步:在重写的方法里面有三个参数,用method调用invoke方法,将obj和args参数传递,返回一个Object类型的
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
		System.out.println("1.准备工作..");
		Object result = method.invoke(obj, args);
		System.out.println("3,收尾工作");
		return result;
	}

}
