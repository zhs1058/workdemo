package test;

class Base {
Base() { System.out.print("base"); }
}
public class Alpha extends Base {
public static void main( String[] args ) {
new Alpha();//-----���ø����޲εĹ��췽��
new Base();
}
}