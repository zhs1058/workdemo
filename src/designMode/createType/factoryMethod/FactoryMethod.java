package designMode.createType.factoryMethod;

/**
 * ��������ģʽ
 * һ���ŵ㣺
 * �û�ֻ��Ҫ֪�����幤�������ƾͿɵõ���Ҫ�Ĳ�Ʒ������֪����Ʒ�ľ��崴�����̡�
 * �������ǿ�������²�Ʒ�Ĵ�����ֻ���дһ����Ӧ�Ĺ����ࡣ
 * ���͵Ľ����ܡ��߲�ģ��ֻ��Ҫ֪����Ʒ�ĳ����࣬�����������ʵ���࣬��������ط�����������ԭ��������滻ԭ��
 * ����ȱ�㣺
 * ��ĸ������׹��࣬���Ӹ��Ӷ�
 * ������ϵͳ�ĳ����Ժ�����Ѷ�
 * �����Ʒֻ������һ�ֲ�Ʒ���˱׶˿�ʹ�ó��󹤳�ģʽ���
 * ����Ӧ�ó�����
 * �ͻ�ֻ֪��������Ʒ�Ĺ�����������֪������Ĳ�Ʒ������ TCL ���ӹ��������ŵ��ӹ����ȡ�
 * ��������������ɶ�������ӹ����е�ĳһ����ɣ������󹤳�ֻ�ṩ������Ʒ�Ľӿڡ�
 * �ͻ������Ĵ�����Ʒ��ϸ�ڣ�ֻ���Ĳ�Ʒ��Ʒ��
 * @author HsZ
 *
 */
public class FactoryMethod {

	public static void main(String[] args) {
		AnimalFarm animalFarm = new HorseFarm();
		Animal animal = animalFarm.createProduce();
		animal.show();
		
	}
}

abstract class Animal{
	public abstract void show();
}

interface AnimalFarm{
	public Animal createProduce();
}

class Horse extends Animal{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("�����˻��");
		
	}
	
}

class Cattle extends Animal{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("ţ���ڸ���");
	}
	
}

class HorseFarm implements AnimalFarm{

	@Override
	public Animal createProduce() {
		return new Horse();
		// TODO Auto-generated method stub
		
	}
	
}

class CattleFarm implements AnimalFarm{

	@Override
	public Animal createProduce() {
		// TODO Auto-generated method stub
		return new Cattle();
	}
	
}
