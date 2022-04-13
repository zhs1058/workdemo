package designMode.structuralType.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一、代理模式的主要优点有：
 * 1、代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 * 2、代理对象可以扩展目标对象的功能；
 * 3、代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性
 * 
 * 二、其主要缺点是：
 * 1、代理模式会造成系统设计中类的数量增加
 * 2、在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
 * 3、增加了系统的复杂度；
 * @author 89704
 *
 */
public class ProxyMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//IPerson proxy = new ZhongJie(new FangDong());
		IPerson proxy = new JDKZhongJie().getInstance(new FangDong());
		proxy.lease();
	}

}

interface IPerson{
	public void lease();
}

class FangDong implements IPerson{

	@Override
	public void lease() {
		// TODO Auto-generated method stub
		System.out.println("我有一个房子需要出租");
	}
	
}

class JDKZhongJie implements InvocationHandler{

	private IPerson person;
	
	public IPerson getInstance(IPerson person) {
		this.person = person;
		
		return (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		beforeLease();
		Object o = method.invoke(this.person, args);
		afterLease();
		return o;
	}
	
	private void beforeLease() {
		System.out.println("在找房子前，需要说明你的租房需求");
	}
	
	private void afterLease() {
		System.out.println("如果满意这个房子，请签约合同");
	}
	
}

class ZhongJie implements IPerson{

	private IPerson person;
	
	ZhongJie(IPerson person){
		this.person = person;
	}
	@Override
	public void lease() {
		// TODO Auto-generated method stub
		beforeLease();
		person.lease();
		afterLease();
		
	}
	
	private void beforeLease() {
		System.out.println("在找房子前，需要说明你的租房需求");
	}
	
	private void afterLease() {
		System.out.println("如果满意这个房子，请签约合同");
	}
}
