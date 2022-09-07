package test;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class test1 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		Vector<String> v = new Vector<>();
//		HashSet<String> set = new HashSet<String>();
		set.add("s");
		TreeSet<String> set2 = new TreeSet<String>();
		set2.add("s");
		//A a = new B();
		Double a = 2.15;
		String s = "s";
		Double b = 1.10;
		System.out.println(a-b);
		//a.print();
	}
	
}

class A {
	
	
	public void print1() {
		System.out.println("我是父类");
	}
}

class B extends A{

	
	public void print1() {
//		System.out.println("我被执行了");
//		super.print1();
		System.out.println("我是子类");
	}
}
