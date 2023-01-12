package test;

class AA {
	public static void printa() {
		System.out.println("A");
	}
}

class BB extends AA {
	public static void printb() {
		System.out.println("B");
	}
}


public class test6 extends BB {

	public static void main(String[] args) {
		int[] num = {23,34};
		printa();
		printb();
	}
}


