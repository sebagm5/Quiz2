import java.time.LocalDate;
import java.util.Scanner;

public class WorkerDatabase {
	//create a variable to count the position of the array
	public static int count = 0;
	public static void main(String[] args) throws InvalidNameException, InvalidShiftException {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);		
		Worker[] workerDB = new Worker[20];		
		//create a while loop to display the methods until the application is finished
		while(true) {
			printMenu(sc,workerDB);
			sortDB(workerDB);
			for(int i=0; i<count; i++) {
				System.out.println(workerDB[i].toString());
			}
		}
	}
	
	// Function to print the main menu where the user can chose between add, delete, or quit a record.
	public static void printMenu(Scanner sc, Worker workerDB[]) throws InvalidNameException, InvalidShiftException{
		System.out.println("Do you want to (A)dd or (D)elete a record or (Q)uit >> ");
		String option = sc.nextLine();
		// if "count" is equal to the length of the array then the database will be full.
		// Otherwise, the recordDatabase function will be called
		if(option.equals("A")) {
			if(count == workerDB.length) {
				System.out.println("This database is full");
			}
			else{
				recordDatabase(sc,workerDB);					
			}
		}
		// if "count" is equal to 0 then the database will be empty.
		//Otherwise, the user is prompted for the id that he wants to delete and the searchID function will be called too see if it exists.
		// if it exists, the delete function is called. 
		if(option.equals("D")) {
			if(count == 0) {
				System.out.println("This database is empty");
			}
			if(count >0) {
				System.out.println("Enter worker id to delete >> ");
				String workerID = sc.nextLine();
				searchID(workerID,workerDB);
				if(searchID(workerID,workerDB) == -1) {
					System.out.println("The id does not exist");
				}
				else {
					delete(workerID,workerDB);
				}
			}
		}
		if(option.equals("Q")) {
			System.exit(0);
		}		
	}
	
	// function to register the account. The function requires a Scanner and Worker object. This method throws two exceptions
	public static void recordDatabase(Scanner sc, Worker workerDB[]) throws InvalidNameException, InvalidShiftException {
		System.out.println("Enter account information");
		System.out.println("Enter worker name: ");
		String workerName = sc.nextLine();
		System.out.println("Enter worker ID");
		String workerID = sc.nextLine();
		// if the ID already exists in the database a message is displayed and another ID is requested 
		while(searchID(workerID, workerDB) != -1) {
			System.out.println("The ID already exists");
			System.out.println("Enter worker ID");
			workerID = sc.nextLine();
		}
		System.out.println("Enter hire date (yyyy-mm-dd)");
		String hireDateS = sc.nextLine();
		LocalDate hireDate = LocalDate.parse(hireDateS);
		System.out.println("Enter industry (CONSTRUCTION, MINING, AGRICULTURE, FINISHING)");
		String industry = sc.nextLine();
		System.out.println("Enter work shift (1 for day shift or 2 for night shift)");
		int shift = Integer.parseInt(sc.nextLine());		
		System.out.println("Enter hourly pay rate");
		double hourlyPay = Double.parseDouble(sc.nextLine());
		System.out.println("\nCurrent database:");
		// Depending on the industry, an account will be created in the "count" position, and then +1 is added to the "count" so the next time
		// the account is registered in other position.
		try {
			if(industry.equals("CONSTRUCTION")) {
				ShiftWorker addWorker = new ShiftWorker(workerName, workerID, hireDate, Industry.CONSTRUCTION, shift, hourlyPay);
				workerDB[count] = addWorker;
				count++;
			}
			else if(industry.equals("MINING")) {
				ShiftWorker addWorker = new ShiftWorker(workerName, workerID, hireDate, Industry.MINING, shift, hourlyPay);
				workerDB[count] = addWorker;
				count++;
			}
			else if(industry.equals("AGRICULTURE")) {
				ShiftWorker addWorker = new ShiftWorker(workerName, workerID, hireDate, Industry.AGRICULTURE, shift, hourlyPay);
				workerDB[count] = addWorker;
				count++;
			}
			else if(industry.equals("FINISHING")) {
				ShiftWorker addWorker = new ShiftWorker(workerName, workerID, hireDate, Industry.FINISHING, shift, hourlyPay);
				workerDB[count] = addWorker;
				count++;
			}
			else {
				System.out.println("The industry is invalid");
			}
		} catch (InvalidShiftException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Invalid shift");
			System.out.println("Account is not generated");
		}			
	}
	//function to search if the ID exists.
	// It returns "i" (the position) if it exists or -1 if it does not. 
	public static int searchID(String workerID, Worker workerDB[]) {
		for(int i=0; i<count;i++) {
			if(workerDB[i].getWorkerID().equals(workerID)) {
				return i;
			}
		}
		return -1;
	}
	//function to delete an account.
	// Use the position of the function "searchID" to save it in an int position and then replace that data with the position "position+1"
	// Then, I decrease the variable count by -1
	public static void delete(String workerID, Worker workerDB[]) {
		int position = searchID(workerID, workerDB);
		for(int i = position; i<count-1; i++) {			
			workerDB[i] = workerDB[i+1];
		}
		count--;
		workerDB[count] = new Worker();
	}
	//function to sort the array in ascending order by the workerID of the objects, for this purpose an insertion sort was used.
	// use a lexicographic comparison 
	public static void sortDB(Worker workerDB[]) {
		for(int i=1; i<count; i++) {
			Worker sort;
			sort = workerDB[i];
			int j = i-1;
			
			while(j>=0 && workerDB[j].getWorkerID().compareTo(sort.getWorkerID())>0) {
				workerDB[j+1] = workerDB[j];
				j--;
			}
			workerDB[j+1] = sort;
		}			
	}	
}
