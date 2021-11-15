
public class GradCourse extends Course{
	
	public GradCourse(String courseName) {
		super(courseName);
		setMaxEnrollment();
	}
	
	public void setMaxEnrollment() {
		super.maxEnrollment = 35;
	}
	
	

}
