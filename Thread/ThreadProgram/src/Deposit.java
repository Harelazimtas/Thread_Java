
public class Deposit extends Basic_Account  {

	@Override
	public void run() {
		lock1.lock();
		while(balance+10 > MAX) {
			System.out.println("wait for pull");
			try {
				cond1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock1.unlock();
		lock2.lock();
		System.out.println("deposit 10 NIS");
		balance+=10;
		cond2.signal();
		lock2.unlock();
		

	}

}
