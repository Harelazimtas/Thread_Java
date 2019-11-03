import java.util.concurrent.ForkJoinPool;

public class ThreadMain {
	
	public static void main(String[] args) {
		int factorialNumber=25;
		long result=1;
		System.out.println("calcalute factorial 15");
		for(int i=1;i<=factorialNumber;i++) {
			result*=i;
		}
		System.out.println("The result is= "+result);
		System.out.println("________________________________________________");
		Factorial factorial1=new Factorial(1, (factorialNumber/2));
		Factorial factorial2=new Factorial(factorialNumber/2+1, factorialNumber);
		Thread threadFac1=new Thread(factorial1);
		Thread threadFac2=new Thread(factorial2);
		threadFac1.start();
		threadFac2.start();
		try {
			threadFac1.join();
			threadFac2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The result with two threads is= "+Factorial.res);
		System.out.println("________________________________________________");
		System.out.println("Fork Join");
		FactorialForkJoin f1=new FactorialForkJoin(1, factorialNumber);
		ForkJoinPool pool = new ForkJoinPool();
		long res=pool.invoke(f1);
		System.out.println("The result with fork join  is= "+res);
		System.err.println("\n");
		System.out.println("________________________________________________");
		System.out.println("Deposit and pull with wait and notify");
		Deposit deposit=new Deposit();
		Pull pull=new Pull();
		Thread threadDeposit=new Thread(deposit);
		Thread threadPull=new Thread(pull);
		threadDeposit.start();
		threadPull.start();
		try {
			threadDeposit.join();
			threadPull.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.err.println("\n");
		System.out.println("________________________________________________");
		System.out.println("Dead Lock");
		DeadLock d1=new DeadLock();
		DeadLock d2=new DeadLock();
		Thread t1=new Thread(d1);
		Thread t2=new Thread(d2);
		t1.start();
		t2.start();


		

	}
}
