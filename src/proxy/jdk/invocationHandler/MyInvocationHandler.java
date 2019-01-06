package proxy.jdk.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	//目标对象
	private Object target;
	
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用的方法名-----"+method.getName());
		return method.invoke(target, args);
	}

}
