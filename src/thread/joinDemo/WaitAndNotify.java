package thread.joinDemo;

import java.util.UUID;

public class WaitAndNotify {

	static boolean flag = true;
	static Object lock = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new Wait(),"�߳�1");
		thread1.start();
		
		Thread thread2 = new Thread(new Single(),"�߳�2");
		thread2.start();
	}
	
	static class Wait implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(lock) {
				//while(flag) {
					try {
						System.out.println(Thread.currentThread().getName() + "���ڱ�����");
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "����ִ��");
				//}
				
			}
		}
		
	}
	
	static class Single implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(lock) {
				//while(flag) {
					flag = false;
					lock.notify();
					System.out.println(Thread.currentThread().getName() + "�Ѿ���ʼ֪ͨ");
				//}
			}
			synchronized(lock) {
				
				System.out.println(Thread.currentThread().getName() + "���ڱ�ִ��" + UUID.randomUUID() );
			}
		}
		
	}

}


