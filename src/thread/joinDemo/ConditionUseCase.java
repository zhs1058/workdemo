package thread.joinDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
	
	static Lock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conditionWait();
		conditionSingle();
	}

	public static void conditionWait() {
		lock.lock();
		
		try {
			System.out.println("ËøµÈ´ý");
			condition.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void conditionSingle() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.lock();
		try {
			System.out.println("ËøÍ¨Öª");
			condition.signal();
		}finally {
			lock.unlock();
		}
		
	}
}
