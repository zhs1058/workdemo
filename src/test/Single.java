package test;

public class Single { //˫����  ���������ʽ�Ͷ���ʽ
	
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

class Single2{ //����ʽ  �ô���û���ֳɰ�ȫ���⣬�������˷ѿռ�
	private static Single2 instance = new Single2();
	
	private Single2() {}

	public static Single2 getInstance() {
		return instance;
	}
}
