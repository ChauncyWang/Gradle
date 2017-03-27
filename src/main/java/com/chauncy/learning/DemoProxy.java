package com.chauncy.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理学习
 * Created by chauncy on 17-3-13.
 */
public class DemoProxy {
	public static void main(String[] args){
		ImplSubject implSubject = new ImplSubject();
		ISubject subject = (ISubject)Proxy.newProxyInstance(implSubject.getClass().getClassLoader(),new Class[]{ISubject.class},new ProxyHandler(implSubject));

		subject.doSomething();
	}
}
interface ISubject {
	public void doSomething();
}
class ImplSubject implements ISubject {

	@Override
	public void doSomething() {
		System.out.println("do something...");
	}
}
class ProxyHandler implements InvocationHandler {

	private Object proxy;
	public ProxyHandler(Object proxy) {
		this.proxy = proxy;
	}

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
		System.out.println(method.getName());
		Object result = method.invoke(proxy,objects);
		System.out.println("GG");
		return result;
	}
}
