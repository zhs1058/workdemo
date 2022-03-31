package designMode;

/**
 * �򵥹�������ģʽ
 * һ���ŵ㣺
 * �����������Ҫ���߼��жϣ����Ծ�����ʲôʱ�򴴽���һ����Ʒ��ʵ�����ͻ��˿������ֱ�Ӵ�����Ʒ�����ְ�𣬺ܷ���Ĵ�������Ӧ�Ĳ�Ʒ�������Ͳ�Ʒ��ְ��������ȷ��
 * �ͻ�������֪�������������Ʒ��������ֻ��֪���������ɡ�
 * Ҳ�������������ļ����ڲ��޸Ŀͻ��˴��������¸���������µľ����Ʒ�ࡣ
 * ����ȱ�㣺
 * �򵥹���ģʽ�Ĺ����൥һ���������в�Ʒ�Ĵ�����ְ����أ�һ���쳣������ϵͳ����Ӱ�졣�ҹ���������ǳ�ӷ�ף�Υ���߾ۺ�ԭ��
 * ʹ�ü򵥹���ģʽ������ϵͳ����ĸ����������µĹ����ࣩ������ϵͳ�ĸ��ӶȺ�����Ѷ�
 * ϵͳ��չ���ѣ�һ�������²�Ʒ���ò��޸Ĺ����߼����ڲ�Ʒ���ͽ϶�ʱ����������߼����ڸ���
 * �򵥹���ģʽʹ���� static ������������ɹ�����ɫ�޷��γɻ��ڼ̳еĵȼ��ṹ��
 * ����Ӧ�ó���
 * ���ڲ�Ʒ������Խ��ٵ����������ʹ�ü򵥹���ģʽ��ʹ�ü򵥹���ģʽ�Ŀͻ���ֻ��Ҫ���빤����Ĳ���������Ҫ������δ���������߼������Ժܷ���ش��������Ʒ��
 * @author HsZ
 *
 */
public class SimpleFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory.showProduct("TCL").showTV();
	}

}

abstract class Product {
	abstract void showTV();
}

class Haier extends Product{

	@Override
	void showTV() {
		// TODO Auto-generated method stub
		System.out.println("����һ���������ӻ�");
	}
	
}

class TCL extends Product{

	@Override
	void showTV() {
		// TODO Auto-generated method stub
		System.out.println("����һ��TCL���Ƶ��ӻ�");
	}
	
}

class Factory{
	public static Product showProduct(String param) {
		Product product = null;
		if(param.equals("haier")) {
			product = new Haier();
		}else if(param.equals("TCL")) {
			product = new TCL();
		}
		return product;
	}
}