package test;

import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		
		
		int[] a = new int[10];
		for(int i = 0; i < 10; i ++) {
			Scanner input = new Scanner(System.in);
			a[i] = input.nextInt();
		}
		
		quickSort(a, 0, a.length-1);
		
		for(int i = 0; i < 10; i ++) {
			System.out.println(a[i]);
		}
	}
	
	private static void quickSort(int[] a, int left, int right) {
		
		if(left < right) {
			int temp = a[left];
			int l = left, r = right;
			while(l < r) {
				while(l < r && a[r] >= temp) {
					r --;
				}
				a[l] = a[r];
				while(l < r && a[l] <= temp) {
					l ++;
				}
				a[r] = a[l];
			}
			a[l] = temp;
			quickSort(a, left, l-1);
			quickSort(a,l+1, right);
		}
	}
}
