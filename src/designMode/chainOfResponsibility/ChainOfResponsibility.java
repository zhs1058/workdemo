package designMode.chainOfResponsibility;

/**
 * 
 * һ��������ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 * 1�������˶���֮�����϶ȡ���ģʽʹ��һ����������֪����������һ���������������Լ����Ľṹ�������ߺͽ�����Ҳ����ӵ�жԷ�����ȷ��Ϣ��
 * 2����ǿ��ϵͳ�Ŀ���չ�ԡ����Ը�����Ҫ�����µ��������࣬���㿪��ԭ��
 * 3����ǿ�˸�����ָ��ְ�������ԡ����������̷����仯�����Զ�̬�ظı����ڵĳ�Ա���ߵ������ǵĴ���Ҳ�ɶ�̬����������ɾ�����Ρ�
 * 4�����������˶���֮������ӡ�ÿ������ֻ�豣��һ��ָ�������ߵ����ã����豣���������д����ߵ����ã��������ʹ���ڶ�� if ���� if������else ��䡣
 * 5�����ηֵ���ÿ����ֻ��Ҫ�����Լ��ô���Ĺ��������ô���Ĵ��ݸ���һ��������ɣ���ȷ��������η�Χ��������ĵ�һְ��ԭ��
 * 
 * ��������Ҫȱ�����¡�
 * 1�����ܱ�֤ÿ������һ������������һ������û����ȷ�Ľ����ߣ����Բ��ܱ�֤��һ���ᱻ�������������һֱ��������ĩ�˶��ò�������
 * 2���ԱȽϳ���ְ����������Ĵ�������漰����������ϵͳ���ܽ��ܵ�һ��Ӱ�졣
 * 3��ְ���������ĺ�����Ҫ���ͻ�������֤�������˿ͻ��˵ĸ����ԣ����ܻ�����ְ�����Ĵ������ö�����ϵͳ��������ܻ����ѭ�����á�
 * @author 89704
 *
 */
public class ChainOfResponsibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler h1 = new ConcreteHandler1();
		Handler h2 = new ConcreteHandler2();
		Handler h3 = new ConcreteHandler3();
		h1.setNext(h2);
		h2.setNext(h3);
		h1.doHandler(1);
	}

}

abstract class Handler{
	private Handler next;
	
	public Handler getNext() {
		return this.next;
	}
	
	public void setNext(Handler handler) {
		this.next = handler;
	}
	
	public abstract void doHandler(int days);
}

class ConcreteHandler1 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		if(days <= 2) {
			System.out.println("�������ʦ����׼��");
		}else {
			System.out.println("��ʦ��Ȩ��������ת����һ�����ڵ�");
			getNext().doHandler(days);
		}
	}
	
}

class ConcreteHandler2 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		if(days <= 7) {
			System.out.println("һ�ܼٽ̵����θ���׼��");
		}else {
			System.out.println("�̵�������Ȩ��������ת����һ�����ڵ�");
			getNext().doHandler(days);
		}
	}
	
}

class ConcreteHandler3 extends Handler{

	@Override
	public void doHandler(int days) {
		// TODO Auto-generated method stub
		System.out.println("�������ѧ");
	}
	
}
