package test;

import java.sql.SQLException;
import java.util.Scanner;

public class Link {
	public static void main(String[] args) {
		Linked head = new Linked();
		Linked p1 = head;
		for(int i = 0; i < 5; i ++) {
			Scanner input = new Scanner(System.in);
			Linked np = new Linked();
			np.value =  input.nextInt();
			
			p1.next = np;
			p1 = np;
		}
		Linked res = null;
		Linked next = null;
		Linked l1 = head.next;
		l1.dosth1();
		while(l1 != null) {
			
			next = l1.next;
			l1.next = res;
			res = l1;
			l1 = next;
		}
		while(res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}
	
	public static class Linked {
		public int value;
		public Linked next;
		
		public void dosth1() throws NullPointerException{}
	}

}
