package designMode.templateMethod;
/**
 * ģ�巽����������������ͬ�����Ǹ������ھ������ݲ�ͬ
 * ���������ѧ����һ�㾭���������̣���ȡѧУ���ϣ������ѧ���룬
 * ������˽�������ա��������͹�֤������ǩ֤����졢����Ʊ��׼����װ��
 * �ִ�Ŀ��ѧУ�ȣ�������Щҵ��Ը���ѧУ��һ���ģ�
 * ����Щҵ����ѧУ��ͬ����ͬ�����ԱȽ��ʺ���ģ�巽��ģʽ��ʵ�֡�
 * @author HsZ
 *
 */
public class TemplateMethod {

	public static void main(String[] args) {
		OverseasStudy overStudy1 = new zhangsan();
		OverseasStudy overStudy2 = new lisi();
		overStudy1.method();
		overStudy2.method();
	}
	
}

abstract class OverseasStudy {
	/**
	 * ��ҵѧУ
	 */
	abstract void graduationSchool();
	
	/**
	 * ������Ϣ
	 */
	abstract void passportInfo();
	
	/**
	 * Ŀ�ĵ�
	 */
	abstract void destination();
	
	public void method() {
		graduationSchool();
		passportInfo();
		destination();
	}
	
}

class zhangsan extends OverseasStudy {

	@Override
	void graduationSchool() {
		// TODO Auto-generated method stub
		System.out.print("�ұ�ҵ�ڱ�����ѧ    ");
		
	}

	@Override
	void passportInfo() {
		// TODO Auto-generated method stub
		System.out.print("�ҵĻ�����Ϣ�����������������䣺19�ꣻ�������й�     ");
		
	}

	@Override
	void destination() {
		// TODO Auto-generated method stub
		System.out.println("�ҵ���ѧĿ�ĵ��ǵ¹�");
	}
	
}

class lisi extends OverseasStudy {

	@Override
	void graduationSchool() {
		// TODO Auto-generated method stub
		System.out.print("�ұ�ҵ���Ͼ���ѧ    ");
		
	}

	@Override
	void passportInfo() {
		// TODO Auto-generated method stub
		System.out.print("�ҵĻ�����Ϣ�����������ģ����䣺20�ꣻ�������й�     ");
	}

	@Override
	void destination() {
		// TODO Auto-generated method stub
		System.out.println("�ҵ���ѧĿ�ĵ�������");
	}
	
}