import java.time.LocalDate;


public class ShiftWorker extends Worker{
		private int shift;
		private double hourlyPay;
		// default constructor
		public ShiftWorker() {
			
		}
		// constructor that requires super and local parameters. 
		public ShiftWorker(String workerName, String workerID, LocalDate hireDate, Industry industry, int shift, double hourlyPay) throws InvalidShiftException, InvalidNameException{
			super(workerName, workerID, hireDate, industry);
			// throw an exception if the shift number is invalid
			if(shift != 1 && shift !=2) {
				throw(new InvalidShiftException());
			}
			this.shift = shift;
			this.hourlyPay = hourlyPay;
		}
		// get and set methods for the fields.
		public int getShift() {
			return shift;
		}
		public void setShift(int shift) {
			this.shift = shift;
		}
		
		public double getHourlyPay() {
			return hourlyPay;
		}
		public void setHourlyPay(double hourlyPay) {
			this.hourlyPay = hourlyPay;
		}
		// Create to toString() method
		public String toString() {
			String shiftS;
			if(shift == 1) {
				shiftS = "day";
			}
			else {
				shiftS = "night";
			}
			String info = super.toString()+"  Work "+shiftS+ " shift"+ "\n  Hourly pay rate: " +hourlyPay;
			return info;
		}		
}
