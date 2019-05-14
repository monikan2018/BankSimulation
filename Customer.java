
/*****
 * Program  to store customer data for the simulate the operation of a small bank. It also clacluate the longest wait time for any customer experience. 
 * Each customer record can be printed.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
public class Customer{
	
    private int cust_number;	
	private int cust_arrivalTime;
	private int cust_startServiceTime;
	private int cust_serviceTime;
	private int cust_waitTime;
	private int cust_completionTime;
	int[][]customerArray =new int[400][6];
	
		
	public Customer() {											//constructor for customer
		cust_number = 0;
		cust_arrivalTime = 0;
		cust_waitTime = 0;
		cust_startServiceTime = 0;
		cust_serviceTime = 0;
		cust_completionTime =0;
	}
	
	public void storeCustomerData(int cust) {					// assig customer data to array locations to store 
		customerArray[cust] [0]= cust_number;
		customerArray[cust] [1]= cust_arrivalTime;
		customerArray[cust] [2]= cust_waitTime;
		customerArray[cust] [3]= cust_startServiceTime;
		customerArray[cust] [4]= cust_serviceTime;
		customerArray[cust] [5]= cust_completionTime;
	}
	

	public int LongestWaitTime() {								// calculate longest wait time any customer experience
		int longestOne =0;		
		for (int i =0; i <customerArray.length; i++) {
			if ( getCust_waitTime(i) > longestOne) {
				longestOne  = getCust_waitTime(i);
			}			
		}
		return longestOne;
	}
	public int getCust_serviceTime() {
		return cust_serviceTime;
	}
	public void setCust_serviceTime(int cust_serviceTime) {
		this.cust_serviceTime = cust_serviceTime;
	}
	public int getCust_number() {
		return cust_number;
	}

	public void setCust_number(int cust_number) {
		this.cust_number = cust_number;
	}
	public void setCust_arrivalTime(int cust_arrivalTime) {
		this.cust_arrivalTime = cust_arrivalTime;
	}
	public void setCust_waitTime() {
		this.cust_waitTime =  cust_startServiceTime - cust_arrivalTime;
	}
	
	public void setCust_startServiceTime(int currTime) {
		this.cust_startServiceTime = currTime;
	}
	
	public void setCust_completionTime() {
		this.cust_completionTime = cust_startServiceTime+cust_serviceTime;
	}
	
	public int getCust_arrivalTime(int custNum) {
		return (customerArray[custNum] [2]);
	}
	
	public int getCust_waitTime(int custNum) {
		return (customerArray[custNum] [2]);
	}

	public int getCust_startServiceTime(int custNum) {
		return (customerArray[custNum] [3]);
	}

	
	public int getCust_completionTime(int custNum) {
		return (customerArray[custNum] [5]);
	}
	
	public void getCustomerData(int c) {									//prints customer data
		System.out.println("Cust# "+customerArray[c] [0]);
		System.out.println("CArrT "+customerArray[c] [1]);
		System.out.println("CWaitT " +customerArray[c] [2]);		
		System.out.println("CSerStartT "+customerArray[c] [3]);
		System.out.println("CServiceT "+customerArray[c] [4]);
		System.out.println("CCompletionT "+customerArray[c] [5]);
		
	}
}
	

	