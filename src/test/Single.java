package test;

public class Single { //双检锁  结合了懒汉式和饿汉式
	
	private static Single instance;
	private Single() {}
	
	public static Single getInstance() {
		if(instance != null) {
			synchronized(Single.class){
				if(instance != null) {
					instance = new Single();
				}
			}
		}
		return instance;
	}

}

class Single2{ //饿汉式  好处是没有现成安全问题，坏处是浪费空间
	private static Single2 instance = new Single2();
	
	private Single2() {}

	public static Single2 getInstance() {
		return instance;
	}
}
