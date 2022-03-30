package test;

import java.util.ArrayList;
import java.util.List;

public class PECS {
	public static void main(String[] args) {
		Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple());
		Plate<? super Apple> p2 = new Plate<Fruit>(new Apple());
		p1.get().show();
		p2.set(new Apple());
		p2.set(new RedApple());
		p2.set(new RedApple());
	}
	

}
 class Fruit {
	
	public void show() {
		System.out.println("����ˮ��");
	}
	
}

 class Apple extends Fruit{
	public void show() {
		System.out.println("����һ��ƻ��");
	}
}
 class RedApple extends Apple{
	public void show() {
		System.out.println("����һ����ʿ��ƻ��");
	}
}
 class Plate<T>{
	private T item;
	public Plate (T t){
		item = t;
	}
	public void set(T t) {
		item = t;
	}
	public T get() {
		return item;
	}
}
