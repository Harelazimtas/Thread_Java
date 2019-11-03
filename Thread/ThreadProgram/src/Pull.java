
public class Pull extends Basic_Account  {

	@Override
	public void run() {
		lock1.lock();
		while(balance+10 > MAX) {
			balance-=50;
			System.out.println("pull 10 NIS and wake up the thread Deposit");
		}
		cond1.signal();
		lock1.unlock();

		lock2.lock();
		while(balance-10 <=0) {
			System.out.println("wait for deposit");
			try {
				cond2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("can pull now");
		lock2.unlock();
		
		
	}

}
