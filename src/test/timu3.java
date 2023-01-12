package test;

public class timu3 implements Runnable {
	private int i = 0;
	private int j = 0;
	public static void main(String[] args) {
		timu3 t = new timu3();
		new Thread(t).start();
		new Thread(t).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x < 10; x ++) {
			i ++;
			j ++;
			System.out.println(" i= " + i + " j= " + j);
		}
	}

}
