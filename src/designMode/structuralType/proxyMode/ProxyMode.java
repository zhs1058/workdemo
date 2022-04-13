package designMode.structuralType.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * һ������ģʽ����Ҫ�ŵ��У�
 * 1������ģʽ�ڿͻ�����Ŀ�����֮����һ���н����úͱ���Ŀ���������ã�
 * 2��������������չĿ�����Ĺ��ܣ�
 * 3������ģʽ�ܽ��ͻ�����Ŀ�������룬��һ���̶��Ͻ�����ϵͳ����϶ȣ������˳���Ŀ���չ��
 * 
 * ��������Ҫȱ���ǣ�
 * 1������ģʽ�����ϵͳ����������������
 * 2���ڿͻ��˺�Ŀ�����֮������һ��������󣬻�����������ٶȱ�����
 * 3��������ϵͳ�ĸ��Ӷȣ�
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
		System.out.println("����һ��������Ҫ����");
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
		System.out.println("���ҷ���ǰ����Ҫ˵������ⷿ����");
	}
	
	private void afterLease() {
		System.out.println("�������������ӣ���ǩԼ��ͬ");
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
		System.out.println("���ҷ���ǰ����Ҫ˵������ⷿ����");
	}
	
	private void afterLease() {
		System.out.println("�������������ӣ���ǩԼ��ͬ");
	}
}
