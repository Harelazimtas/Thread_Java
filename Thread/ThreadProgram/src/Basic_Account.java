import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Basic_Account implements Runnable  {
	protected static int balance=55;
	protected static Lock lock1 = new ReentrantLock();
	protected static Lock lock2 = new ReentrantLock();
	protected final int MAX=60;
	protected static Condition cond1=lock1.newCondition(); 
	protected static Condition cond2=lock2.newCondition(); 
	
	@Override
	public abstract void run();
			
	
	
	

}
