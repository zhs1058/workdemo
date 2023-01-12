package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class YuanGong {
	int num; //编号
	int days = 0; // 打卡天数
	int date = 0; //最早打卡日期
	YuanGong(int num) {
		this.num = num;
	}
}

public class timu1 {

	private static final String YuanGong = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<YuanGong> ygList = new ArrayList<>();
		int n = in.nextInt();
		for(int i = 0; i < n; i ++) {
			ygList.add(new YuanGong(i));
		}
		int[] days = new int[31];
		for(int i = 1; i <= 30; i ++) {
			days[i] = in.nextInt();
		}
		for(int i = 1; i <= 30; i ++) {
			for(int j = 0; j < days[i]; j ++) {
				int num = in.nextInt();
				ygList.get(num).days ++;
				if( ygList.get(num).date == 0) {
					ygList.get(num).date = i;
				}
				 
			}
		}
		ygList.sort(new Comparator<YuanGong>() {

			@Override
			public int compare(YuanGong o1,YuanGong o2) {
				if(o1.days > o2.days ) {
					return -1;
				}else if(o1.days < o2.days) {
					return 1;
				}else {
					if(o1.date < o2.date) {
						return -1;
					}else if(o1.date == o2.date) {
						if(o1.num < o2.num) {
							return -1;
						}
					}
				}
				return 0;
			}
			
		});
		
	}

	
	
	
}
