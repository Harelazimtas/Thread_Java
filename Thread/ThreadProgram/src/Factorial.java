
public class Factorial  implements Runnable{
	private int min;
	private int max;
	public static long res=1;
	
	
	public Factorial(int min, int max) {
		this.min = min;
		this.max = max;
	}


	@Override
	public void run() {
		for(int i=min;i<=max;i++) {
			res*=i;
			
			
		}
		
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
