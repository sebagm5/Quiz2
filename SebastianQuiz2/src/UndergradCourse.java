
public class UndergradCourse extends Course{
	
	public UndergradCourse(String courseName) {
		super(courseName);
		setMaxEnrollment();
	}
	
	public void setMaxEnrollment() {
		super.maxEnrollment = 45;
	}
	
	

}
