import java.util.Scanner;
/*****
 * Program is the simulate the operation of a small bank. Input from user accepted to set arrival times at min/max intervals. Generate arrival time of first 
 * customer and serve the first customer. The generate arrival times for other customer are if the teller is free serve the customer or put them in queue to
 * serve once teller is available. If it is the last customer serve the customer and service completion time is more then simulation time ,break the loop and 
 * dequeue the customers in the queue. Print dequeue customers arrival times. Queue depth  at the end of the program and the maximum depth of the is also 
 * printed at the end. 
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
public class BankSimulator {
		//Initialize variables and classes
		static final int sim_Runtime = 480;
		int minAT ;
		int maxAT ;
		int minST = 1;
		int maxST = 4;		
		int firstAT;
		int nextAT;
		int nextST;
		int foundTL;
		int count =0;
		int nextCust;
		int currentMinute;

		LQueue<Integer> arrivalTimes = new LQueue<Integer>();
		Customer customer =new Customer();
		Teller teller = new Teller();		
		Calculate_Ops ops = new Calculate_Ops();
		
		// Main loop that runs during the simultion time.
		public void runSimulator() 
		{
		    getUserInput();											//set the minimum and maximum(in  minutes)time between which each customer arrives
			firstAT = ops.random_Num(minAT,maxAT);								//random number for first customer
			System.out.println("First customer arrived at minute " + firstAT);
			for(currentMinute = 0; currentMinute < sim_Runtime; currentMinute++) 			//loop to run for simulation time
			{		
				
				firstCustomerProcesss();                                   //first customer arrives and processed						 
				customerArrivalProcess();                                  //customer arrives and queued    				
				serviceCustomerProcess();                                   //customers served , customer and teller data stored				
				teller.reduceServiceT(currentMinute);          					//service time reduce
				ops.queueLength[currentMinute] = arrivalTimes.size();			//queue length stored in array								
				if( currentMinute == sim_Runtime){		  	   					// check for last customer
					 lastCustomerProcess(); 									// process last customer 
				     break;		 											 //out of loop if last customer
	    		}
	       }
			System.out.println("Ending Queue Depth = " + arrivalTimes.size());
			ops.maxQueueDepth();						                                 //get the maximum depth of the queue
			System.out.println("Longest wait any customer experienced " + customer.LongestWaitTime()+ " minutes.");
			dequeueCustomers();
		}
		
		
		// Input from user to set arrival times at min/max intervals.
		public void getUserInput()
		{		
			System.out.println("Enter the probability of next Customer Arrival Time: ");
			System.out.println("Minimum Arrival time: ");
			@SuppressWarnings("resource")
			Scanner scr = new Scanner(System.in);
			minAT = scr.nextInt();
			System.out.println("Maximum Arrival time: ");
			maxAT = scr.nextInt();
			
		}
		
		public void firstCustomerProcesss() {
			if(currentMinute == firstAT) {
				setTellerData();														// add teller data
				setCustomerData(firstAT);												// add customer data
			    nextAT = ops.random_Num(minAT, maxAT)+ firstAT;							// generate next random arrival time 
			    arrivalTimes.add(nextAT);												// add arrival time to queue
			 }	
		}
		public void customerArrivalProcess() {
			 if ((currentMinute > firstAT ) && (currentMinute == nextAT))
			 {					
				 nextAT = ops.random_Num(minAT, maxAT)+ nextAT;							//generate random number
				 System.out.println("Next customer arrived at minute " + nextAT);
				 arrivalTimes.add(nextAT);						 						// add to queue
			 }
		}
		
		public void serviceCustomerProcess() {
			 if((!teller.isBusy())&&(!arrivalTimes.isEmpty())) {
					nextCust = arrivalTimes.peek();										// look at next customer arrival time in queue
					if(currentMinute >= nextCust) {										// process customers in queue
					   nextCust = arrivalTimes.remove();								// remove the customers from the queue
					   setTellerData();													// add teller data
					   setCustomerData(nextCust);										// add customer data
			           //System.out.println(nextCust);
					}
				 }
		}
	
		public void lastCustomerProcess() {
			 int C1 = teller.getServing_cust(0);      //get customer # getting served by teller 0 
			 int C2 = teller.getServing_cust(1);      //get customer # getting served by teller 1 
		     if(customer.getCust_completionTime(C1)>sim_Runtime)     // check customer service completion time against total runtime
		     {					    	  
			       System.out.println("Last customer with teller 0 will finish at " + customer.getCust_completionTime(C1));
		     }
		     if(customer.getCust_completionTime(C2)> sim_Runtime)   //  check customer service completion time against total runtime
		     {		
			      System.out.println("Last customer with teller 1 will finish at " + customer.getCust_completionTime(C2));						      
		     }
		}
		
		public void dequeueCustomers()
		{
			while(!arrivalTimes.isEmpty())												// Dequeue customers after simulation time is over
			{
				int nextDequeue =arrivalTimes.remove();
				System.out.println("<ArrivalTimes "+ nextDequeue+" transaction length = "+ customer.getCust_arrivalTime(count)+">");
			}
		}
		// Find the free teller and assign customer and calculate service time for that customer
		public void setTellerData()
		{	
			foundTL =teller.findNextTeller();										// find next available teller
	//		System.out.println("Teller free "+ foundTL);
			nextST = ops.random_Num(minST, maxST);									// generate random service time
			teller.setService_time(nextST);
			teller.setServing_cust(count);
			teller.setService_timeLeft();
			teller.setStatus(1);
			teller.storeTellerData(foundTL);										//stores teller data in array
			//teller.getTellerData(foundTL);										//prints array  data from array
		}
		
		//set the data for customer being served.
		public void setCustomerData(int next) {
			count++;
			customer.setCust_number(count);
			customer.setCust_arrivalTime(next);
			customer.setCust_serviceTime(teller.getService_time(foundTL));				
			customer.setCust_startServiceTime(currentMinute);
			customer.setCust_waitTime();
			customer.setCust_completionTime();
			customer.storeCustomerData(count);										//stores customer data in array
		//  customer.getCustomerData(count);										//prints customer data from array
			
		}
}



