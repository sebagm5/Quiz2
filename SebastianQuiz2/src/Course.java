
public abstract class Course {
	
	private String courseName;
	protected int maxEnrollment;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getMaxEnrollment() {
		return maxEnrollment;
	}
	
	public abstract void setMaxEnrollment();
	
	public String toString() {
		String test = courseName + " Max enrollment " + maxEnrollment;
		return test;
	}

}
