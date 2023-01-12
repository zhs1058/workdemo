package test;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class test2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = 0 , m = 0;
		n = in.nextInt();
		m = in.nextInt();
		int[] dp = new int[m];
		for(int i = 0; i < m; i ++) {
			dp[i] = in.nextInt();
		}
		for(int v : dp) {
			System.out.println(v);
		}
//		if(in.hasNext()) {
//			n = in.nextInt();
//			m = in.nextInt();
//		}
		System.out.println(n + m);
		
//		int a  = 7;
//		int b = ++ a;
//		int c = a++;
//		System.out.println("a=" + a);
//		System.out.println("b=" + b);
//		System.out.println("c=" + c);
//		AtomicLong al = new AtomicLong();
//		LongAdder la = new LongAdder();
//		System.out.println(9/2);
//		int[] dp = new int[10];
//		for(int s : dp) {
//			System.out.println(s);
//		}
	}
}
