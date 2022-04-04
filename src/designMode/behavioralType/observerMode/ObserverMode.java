package designMode.behavioralType.observerMode;

import java.util.Observable;
import java.util.Observer;

/**
 * һ���۲���ģʽ��һ�ֶ�����Ϊ��ģʽ������Ҫ�ŵ����¡�
 * 1��������Ŀ����۲���֮�����Ϲ�ϵ������֮���ǳ�����Ϲ�ϵ��������������ԭ��
 * 2��Ŀ����۲���֮�佨����һ�״������ơ�
 * 
 * ����������Ҫȱ�����¡�
 * 
 * 1��Ŀ����۲���֮���������ϵ��û����ȫ����������п��ܳ���ѭ�����á�
 * 2�����۲��߶���ܶ�ʱ��֪ͨ�ķ����Ứ�Ѻܶ�ʱ�䣬Ӱ������Ч�ʡ�
 * 
 * �� Java �У�ͨ�� java.util.Observable ��� java.util.Observer �ӿڶ����˹۲���ģʽ��
 * ֻҪʵ�����ǵ�����Ϳ��Ա�д�۲���ģʽʵ����
 * @author 89704
 *
 *
 */
public class ObserverMode {

	public static void main(String[] args) {
		OilFutures oliFutures = new OilFutures();
		Observer o1 = new Bull();
		Observer o2 = new Bear();
		oliFutures.addObserver(o1);
		oliFutures.addObserver(o2);
		oliFutures.setPrice(1);
	}
}


class OilFutures extends Observable{
	
	private int price;
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
		super.setChanged();
		super.notifyObservers(price);
	}
}

class Bull implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int price = (int) arg;
        if (price > 0) {
            System.out.println("�ͼ�����" + price + "Ԫ���෽�����ˣ�");
        } else {
            System.out.println("�ͼ��µ�" + (-price) + "Ԫ���෽�����ˣ�");
        }
	}
	
}

class Bear implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int price = (int) arg;
        if (price > 0) {
            System.out.println("�ͼ�����" + price + "Ԫ���շ������ˣ�");
        } else {
            System.out.println("�ͼ��µ�" + (-price) + "Ԫ���շ������ˣ�");
        }
	}
	
}