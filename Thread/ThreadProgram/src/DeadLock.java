import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock implements Runnable {
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	@Override
	public void run() {
		System.out.println("I try lock lock1: " + Thread.currentThread().getName());
		lock1.lock();
		System.out.println("I lock lock1 " + Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I try lock lock2, and lock the lock1: " + Thread.currentThread().getName());
		lock2.lock();
		System.out.println("I lock lock2 " + Thread.currentThread().getName());
		lock1.unlock();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I try lock lock1, and lock the lock2 " + Thread.currentThread().getName());
		lock1.lock();
		lock1.unlock();
		lock2.unlock();
		
		System.out.println("I unlock lock2 " + Thread.currentThread().getName());

	}

}
