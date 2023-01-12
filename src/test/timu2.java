package test;

import java.util.Scanner;

public class timu2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String v1 = in.next();
		String v2 = in.next();
		
		
		String[] v1s = v1.split("\\.");
		String[] v2s = v2.split("\\.");
		
		if(compare(v1s[0], v2s[0]) != 0) {
			prints(v1, v2, compare(v1s[0], v2s[0]));
		}else if(compare(v1s[1], v2s[1]) != 0) {
			prints(v1, v2, compare(v1s[1], v2s[2]));
		}else if(v1s.length < 3 || v2s.length < 3) {
			prints(v1, v2, v1s.length < v2s.length ? -1 : 1);
		}else {
			String[] vlc1 = v1s[2].split("-");
			String[] vlc2 = v2s[2].split("-");
			if(vlc1.length < 2 || vlc2.length < 2) {
				if(isOnlyNum(vlc1[0]) && isOnlyNum(vlc2[0])) {
					prints(v1, v2, compare(vlc1[0], vlc2[0]));
				}else if(isOnlyNum(vlc1[0]) && !isOnlyNum(vlc2[0])) {
					prints(v1, v2, 1);
				}else if(!isOnlyNum(vlc1[0]) && isOnlyNum(vlc2[0])) {
					prints(v1, v2, -1);
				}else {
					
				}
			}
		}
		
		
		
		
		
		
	}
	private static boolean isOnlyNum(String s) {
		boolean flag = true;
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) < 48 || s.charAt(i) >57) {
				flag = false;
			}
		}
		return flag;
	}
	
	private static void prints(String v1, String v2, int p) {
		if(p > 0) {
			System.out.print(v1);
		}else {
			System.out.print(v2);
		}
		
	}
	
	
	private static int compare(String v1, String v2) {
		
		int vn1 = toNum(v1);
		int vn2 = toNum(v2);
		if(vn1 > vn2) return 1;
		if(vn1 < vn2) return -1;
		if(vn1 == vn2) return 0;
		return 0;
		
		
	}
	
	private static int toNum(String s) {
		int j = 1;
		
		int result = 0;
		for(int i = s.length()-1; i >= 0; i --) {
			char temp = s.charAt(i);
			int n = 1;
			for(int x = 1; x <= j; x++) {
				n = n *10;
			}
			result += temp * j * n;
			j ++;
		}
		return result;
	}
	
}
