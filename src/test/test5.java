package test;

import java.util.ArrayList;
import java.util.List;

public class test5 {
	
	private static List<Bread> list = new ArrayList<Bread>();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Customer(list));
		Thread t2 = new Thread(new Product(list));
		t1.start();
		t2.start();
	}

}

class Customer implements Runnable {

	private List<Bread> list;
	
	Customer(List<Bread> list){
		this.list = list;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized(list) {
				if(list.size() < 1) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.remove(0);
				System.out.println("消费者消费了面包------目前库容量：" + list.size());
				list.notify();
			}
		}
	}
	
}

class Product implements Runnable {
	
	private List<Bread> list;
	
	Product(List<Bread> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized(list) {
				if(list.size() > 9) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Bread bread = new Bread();
				list.add(bread);
				System.out.println("生产者生产了面包------目前库容量：" + list.size());
				list.notify();
			}
		}
		
	}
	
}

class Bread {
	
}
