package test;

public class Father {
	private static String email = "123@qq.com";
	
	public static void main(String[] args) {
		Son son_1 = new Son();
		Son son_2 = new Son("Son");
		Father father = new Son("Son");
	}
	
	Father(){
		System.out.println("���๹�췽��_1");
	}
	
	Father(String email){
		
		System.out.println("���๹�췽��_2");
	}
	
	
	
	static {
		System.out.println(2+"5" );
		System.out.println(email);
	}

}

class Son extends Father{
	Son(){
		System.out.println("��������Ĺ��췽��_1");
	}
	
	Son(String email){
		System.out.println("��������Ĺ��췽��_2");
	}
}