package test;

import java.util.Scanner;

public class linked {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkNode head = new LinkNode();
		LinkNode l = head;
		while(in.hasNextLine()) {
			try {
				int v = in.nextInt();
				LinkNode node = new LinkNode();
				node.value = v;
				node.next = null;
				head.next = node;
				head = node;
			}catch(Exception e) {
				break;
			}
			
		}
		in.next();
		int n = in.nextInt();
		int m = in.nextInt();
		l = l.next;
		LinkNode left = null;
		LinkNode right = null;
		LinkNode star = null;
		LinkNode end = null;
		LinkNode pre = null;
		LinkNode next = null;
		LinkNode cur = l;
		int i = 0;
		while(cur != null) {
			i ++;
			if(i == n - 1) {
				left = cur;
			}
			if(i == m + 1) {
				right = cur;
			}
			
			if(i >= n && i <= m) {
				if(i == n) {
					star = cur;
				}
				if(i == m) {
					end = cur;
				}
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}else {
				pre = cur;
				cur = cur.next;
			}
		}
		if(left == null) {
			l = end;
		}else {
			left.next = end;
		}
		star.next = right;
		
		while(l != null) {
			System.out.print(l.value);
			l = l.next;
		}
		
		
		
	}

}

class LinkNode {
    int value;
    LinkNode next;
}
