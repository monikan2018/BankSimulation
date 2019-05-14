/*****
 * Program is to store data simulate the operation of a small bank. Input from user accepted to set arrival times at min/max intervals. 
 * The line at the bank will be a queue.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
  public class Teller {
	  	int numtellers =2;
		public int[][] tellerA = new int[numtellers+1][5]; 
		private int Teller_ID;
		private int service_time;
		private int service_timeLeft;
		private int status;
		private int serving_cust;
	
		public Teller() {											//constructor
			Teller_ID = 0;
			service_time =0;
			status = 0;
			service_timeLeft =0;
			serving_cust = 0;
		}

	
		public void storeTellerData(int t) {									//assign data to array
			 tellerA[t][0] = Teller_ID;
			 tellerA[t][1] = service_time;
			 tellerA[t][2] = service_timeLeft;
			 tellerA[t][3] = status;
			 tellerA[t][4] = serving_cust;
			// Display();
		 }
		
		// Reduce the service time of a teller if still serving customer
		 public void reduceServiceT(int currentMinute) {
				if (tellerA[0][2] > 0)						//check teller 0 service time
				{
				 tellerA[0][2]--;
				 if (tellerA[0][2]==0) {					//change status equals 0 if service time is 0
					 tellerA[0][3] = 0;	
					 System.out.println("Teller 0 finished customer, at minute "+ currentMinute);
				 }
				}
				if (tellerA[1][2] > 0)						// check teller 1 for service time
					{
					 tellerA[1][2]--;
					 if(tellerA[1][2]==0) {					//change status equals 0 if service time is 0
						tellerA[1][3] = 0;	
						 System.out.println("Teller 1 finished customer, at minute "+ currentMinute);
					 }
					}
		 }
		 
		 // Find next free teller 
		public int findNextTeller() {
			int freeTeller = -1;
			 if(tellerA[0][3] == 0 ){								//if status equals teller 0 is free and return the value
				freeTeller =0;
			 }else
			 {
			 if(tellerA[1][3]==0)	 								//if status equals teller 1 is free and return the value
				freeTeller = 1;
			}
			 return freeTeller;
		}
		
		//check if both teller are busy
		public boolean isBusy() {
			 if((tellerA[0][3] == 1 ) && (tellerA[1][3] == 1 )) {
					return true;
		
		}	
		return false;
	    }

		//check is any one of the tellers is free
		public boolean isfree() {
		 if((tellerA[0][3] == 0 ) || (tellerA[1][3] == 0 )) {
					return true;
		
			}	
			return false;
		}
	
		 
		// setter and getters for construct
			public int getTeller_ID() {
				return Teller_ID;
			}

			public void setTeller_ID(int teller_ID) {
				Teller_ID = teller_ID;
			}

			public int getService_time(int t) {
				return tellerA[t][1];
			}

			public void setService_time(int service_time) {
				this.service_time = service_time;
			}

			public int getService_timeLeft(int t) {
				return tellerA[t][2];
			}

			public void setService_timeLeft() {
				this.service_timeLeft = service_time;
			}

			 public int getServing_cust(int t) {
				return tellerA[t][4];
			}

			public void setServing_cust(int serving_cust) {
				this.serving_cust = serving_cust;
			}		

			public int getStatus(int gteller) {
				return( status = tellerA[gteller][3]);
			    }
		
			
			public void setStatus(int status) {
				this.status = status;
			}
	
			//prints teller data
			public void getTellerData(int t) {
				System.out.println("TID " +tellerA[t][0]);
				System.out.println("TServiceTime " +tellerA[t][1]);
				System.out.println("TSerciceLeft " +tellerA[t][2]);
				System.out.println("TStatus " +tellerA[t][3]);
				System.out.println("TServiceCompletion " +tellerA[t][4]);
			}
	}
