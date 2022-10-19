package thread.joinDemo;

import java.util.UUID;

public class WaitAndNotify {

	static boolean flag = true;
	static Object lock = new Object();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new Wait(),"线程1");
		thread1.start();
		
		Thread thread2 = new Thread(new Single(),"线程2");
		thread2.start();
	}
	
	static class Wait implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(lock) {
				//while(flag) {
					try {
						System.out.println(Thread.currentThread().getName() + "正在被阻塞");
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在执行");
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
					System.out.println(Thread.currentThread().getName() + "已经开始通知");
				//}
			}
			synchronized(lock) {
				
				System.out.println(Thread.currentThread().getName() + "正在被执行" + UUID.randomUUID() );
			}
		}
		
	}

}


