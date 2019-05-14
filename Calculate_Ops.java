
import java.util.Random;
/*****
 * Program  to generate random numbers using the seed. It find from queueLength array maximum queue depth.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */

		public class Calculate_Ops {
			
			
		 int [] queueLength = new int[480];				//initialize array for queue length
		 Random gen = new Random(31415926535L);			//set seed for random numbers
		 
		 // generates random number with min and max limits provided by user
		public int random_Num(int min, int max) {		
			int next;
			next = gen.nextInt(max-min+1)+min;									//generate next random number between min and max numbers
			//next = gen.nextInt();
			return next;
		}
		
		//compares the lengths in array to fine the maximum depth
		public void maxQueueDepth() {
			int maxDepth =0;
			int ql =0;
			for (int i = 0; i < queueLength.length; i++) {
				ql = queueLength[i];
				//System.out.println("display Queue depth= " + ql);
				if (maxDepth < ql)
				{						//compare maximum depth against length in array
					maxDepth = ql;	
				}
			}
			System.out.println("Maximum Queue depth= " + maxDepth);
		}
		

	}
	 
