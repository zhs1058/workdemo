package thread.joinDemo;

public class DeadLock {
	
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new thread1());
		Thread t2 = new Thread(new thread2());
		
		t1.start();
		t2.start();
	}
	
	
	static class thread1 implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(lock1) {
				System.out.println("��ȡ��lock1����");
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				synchronized(lock2) {
					System.out.println("��ȡ��lock1����");
				}
			}
		}
		
	}
	
	static class thread2 implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(lock2) {
				System.out.println("��ȡ��lock2����");
				synchronized(lock1) {
					System.out.println("��ȡ��lock1����");
				}
			}
		}
		
	}

	

}
