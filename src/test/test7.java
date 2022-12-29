package test;

class Base1 {
	int num = 1;
	public Base1() {
		this.print();
		num = 2;
	}
	public void print() {
		System.out.println("Base.num=" + num);
	}
}
class Sub extends Base1 {
	int num = 3;
	public Sub() {
		this.print();
		num = 4;
	}
	public void print() {
		System.out.println("Sub.num=" + num);
	}
}

public class test7 {
	public static void main(String[] args) {
		Base1 b = new Sub();
		System.out.println(b.num);
		b.print();
	}

}
