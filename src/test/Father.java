package test;

public class Father {
	private static String email = "123@qq.com";
	
	public static void main(String[] args) {
		Son son_1 = new Son();
		Son son_2 = new Son("Son");
		Father father = new Son("Son");
	}
	
	Father(){
		System.out.println("父类构造方法_1");
	}
	
	Father(String email){
		
		System.out.println("父类构造方法_2");
	}
	
	
	
	static {
		System.out.println(2+"5" );
		System.out.println(email);
	}

}

class Son extends Father{
	Son(){
		System.out.println("这是子类的构造方法_1");
	}
	
	Son(String email){
		System.out.println("这是子类的构造方法_2");
	}
}