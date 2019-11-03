
import java.util.concurrent.RecursiveTask;

public class FactorialForkJoin extends RecursiveTask<Long>{
	
	private static final long serialVersionUID = 1L;
	private int min;
	private int max;
	public final static int numThread=8 ;
	
	
	public FactorialForkJoin(int min, int max) {
		this.min = min;
		this.max = max;
	}


	@Override
	protected Long compute() {
		if(max-min> numThread) {
			RecursiveTask<Long> f1=new FactorialForkJoin(min, (max+min)/2);
			RecursiveTask<Long> f2=new FactorialForkJoin((max+min)/2+1, max);
			invokeAll(f1,f2);
			return f1.join()*f2.join();
		}
		long res=1;
		for(int i=min;i<=max;i++) {
			res*=i;
		}
		System.out.println("the min= "+min+" and max= "+max+" the res is= "+res);
		return res;
	}
	

	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}

}
