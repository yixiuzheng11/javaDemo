package proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import org.junit.Test;

import proxy.jdk.invocationHandler.MyInvocationHandler;
import proxy.jdk.target.Animal;
import proxy.jdk.target.Person;

public class JdkDemo {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void tesProxy() {
		//目标对象
		Person person = new Person();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(person);
		//生成代理对象
		Animal animal = (Animal) Proxy.newProxyInstance(JdkDemo.class.getClassLoader(), Person.class.getInterfaces(), invocationHandler);
		animal.run();
	}

	@Test
	public void tesProxyComplex() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//目标对象
		Person person = new Person();
		MyInvocationHandler invocationHandler = new MyInvocationHandler(person);
		Class<?> proxyClass = Proxy.getProxyClass(JdkDemo.class.getClassLoader(), Person.class.getInterfaces());
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		//生成代理对象
		Animal animal = (Animal) constructor.newInstance(invocationHandler);
		animal.run();
	}
}
