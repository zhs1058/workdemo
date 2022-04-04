package designMode.behavioralType.observerMode;

import java.util.Observable;
import java.util.Observer;

/**
 * 一、观察者模式是一种对象行为型模式，其主要优点如下。
 * 1、降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。符合依赖倒置原则。
 * 2、目标与观察者之间建立了一套触发机制。
 * 
 * 二、它的主要缺点如下。
 * 
 * 1、目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。
 * 2、当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率。
 * 
 * 在 Java 中，通过 java.util.Observable 类和 java.util.Observer 接口定义了观察者模式，
 * 只要实现它们的子类就可以编写观察者模式实例。
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
            System.out.println("油价上涨" + price + "元，多方高兴了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，多方伤心了！");
        }
	}
	
}

class Bear implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int price = (int) arg;
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
	}
	
}