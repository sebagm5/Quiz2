
public class CourseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Course [] courseClass = new Course [] {		new UndergradCourse("CSIS1175"),
													new UndergradCourse("CSIS2300"),
													new UndergradCourse("CSIS2175"),
													new GradCourse("CSIS4550"),
													new GradCourse("CSIS4350"),
													new GradCourse("CSIS4045"),
												};
		
		System.out.println("Unsorted Course list: ");
		displayCourses(courseClass);
		System.out.println("Sorted Course list: ");
		
		CourseSort(courseClass);
		displayCourses(courseClass);
		
		
		}
	
	public static void displayCourses(Course courseClass[]) {
		for(int i =0; i<courseClass.length; i++) {
			System.out.println("Course # " +courseClass[i].toString() );
			
		}
		
	}
	
	
	public static void CourseSort(Course courseClass []) {
		for(int i = 1; i<courseClass.length; i++) {
			Course num;
			num = courseClass[i];
			int j = i-1;
			
			while(j >= 0 && courseClass[j].getCourseName().compareTo(num.getCourseName()) > 0) {
				courseClass[j+1] = courseClass[j];
				j--;
			}
			courseClass[j+1] = num;
		}
		/*for(Course j: courseClass) {
			System.out.print(j);
		}
		*/
	}
	
	
}


