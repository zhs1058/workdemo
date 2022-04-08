package thread.joinDemo;

import java.util.concurrent.TimeUnit;

public class JoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Thread previous = Thread.currentThread();
		for(int i = 0; i < 10; i ++) {
			Thread thread = new Thread(new Domino(previous), String.valueOf(i));
			thread.start();
			previous = thread;
		}
		System.out.println(Thread.currentThread().getName() + " terminate.");
	}

}

class Domino implements Runnable{

	private Thread thread;
	
	Domino(Thread thread){
		this.thread = thread;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " terminate.");
	}
	
}
