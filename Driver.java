/*****
 * Program is the simulate the operation of a small bank. The bank will need to open for 8 hours a day. The bank must have 2 tellers.
 * The line at the bank will be a queue.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {				//Run bank simulation program
		BankSimulator n1 = new BankSimulator();
			n1.runSimulator();
	}
}
