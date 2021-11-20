package Framework;

import java.io.IOException;
import java.util.ArrayList;

import Domain.Course;
import Domain.Student;
import Utility.Line;

public class CheckFilter extends CommonFilterImpl implements CommonFilter {
	public CheckFilter(int i) {super(i);}
	@Override
	public boolean specificComputationForFilter() throws IOException {
		String line = "";
		ArrayList<Course> courses = new ArrayList<Course>();
		while(true) {
			line = Line.readLine(in.get(0));
			if(line == null) break; 
			courses.add(new Course(line));
		}
		while(true) {
			line = Line.readLine(in.get(1));
			if(line==null) return true; else if(line.isBlank()) continue;
			Student student = new Student(line);
			if(this.isCorrect(courses, student)) {Line.writeLine(student.toString(), out.get(0));} 
			else {Line.writeLine(student.toString(), out.get(1));}
		}
	}
	private boolean isCorrect(ArrayList<Course> courses, Student student) {
		for (String completedCourse : student.getCompletedCoursesList()) {
			for (Course course : courses) {
				if (completedCourse.matches(course.getCourseId())) {
					for (String prerequisity : course.getPrerequisitesList())
						if (student.getCompletedCoursesList().contains(prerequisity))return true;
						else return false;
				}
			}
		}
		return false;
	}
}