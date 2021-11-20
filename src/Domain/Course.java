package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String courseId;
	protected String professor;
	protected String name;
	protected ArrayList<String> prerequisitesList;
	public Course(String inputString) {
		Scanner sc = new Scanner(inputString);
		this.courseId = sc.next();
		this.professor = sc.next();
		this.name = sc.next();
		this.prerequisitesList = new ArrayList<String>();
		while(sc.hasNext()) {
			this.prerequisitesList.add(sc.next());
		}
	}
	 public boolean match(String courseId) {
		 return this.courseId.equals(courseId);
	}
	 public String toString() {
		 String stringReturn = this.courseId + " " + this.professor + " " + this.name;
		 for(String string : this.prerequisitesList) {
			 stringReturn += stringReturn + " " + string;
		 }
		 return stringReturn;
	}
	public String getCourseId() {return courseId;}
	public String getProfessor() {return professor;}
	public String getName() {return name;}
	public ArrayList<String> getPrerequisitesList() { return prerequisitesList;}
}
