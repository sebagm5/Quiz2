import java.time.LocalDate;

public class Worker{
	private String workerName;
	private String workerID;
	private LocalDate hireDate;
	private Industry industry;
	// default constructor
	public Worker() {
		
	}
	// constructor that requires local parameters. 
	public Worker(String workerName, String workerID, LocalDate hireDate, Industry industry) throws InvalidNameException {
		// throw an exception if the worker name contains digits
		for(int i=0; i<workerName.length(); i++) {
			if((workerName.charAt(i)>='0' && workerName.charAt(i)<='9')) {
				throw(new InvalidNameException());
			}		
		}
		this.workerName = workerName;
		this.workerID = workerID;
		this.hireDate = hireDate;
		this.industry = industry;
	}
	// get and set methods for the fields.
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	
	public String getWorkerID() {
		return workerID;
	}
	public void setWorkerID(String workerID) {
		this.workerID = workerID;
	}
	
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}	
	// Create to toString() method
	public String toString() {
		String info = "\nEmployee number "+workerID+"\n  Name: "+workerName+ 
						"\n  Hire date: "+hireDate+ "\n  Industry: "+industry+"\n";
		return info;
	}
}
