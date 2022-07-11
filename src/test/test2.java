package test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class test2 {

	public static void main(String[] args) {
		int a  = 7;
		int b = ++ a;
		int c = a++;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		AtomicLong al = new AtomicLong();
		LongAdder la = new LongAdder();
	}
}
