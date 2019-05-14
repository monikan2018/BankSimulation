import java.util.Random;

public class Calc_operations {
	 int [] queueLength = new int[480];
	 Random gen = new Random();
	// Random gen = new Random(31415926535L);
	public int random_Num(int min, int max) {		
		int next;
		next = gen.nextInt(max-min+1)+min;
		return next;
	}
	
	public Integer maxNumberCustomer() {
		int maxDepth =0;
		for (int i = 0; i < queueLength.length; i++) {
			int ql = queueLength[i];
			if ( maxDepth < ql) {
				maxDepth = ql;
			}
		}
		return maxDepth;
	}
	public void addQueueLength(int length) {
		int i=0;
		queueLength[i] = length;
		i++;
	}

}
  