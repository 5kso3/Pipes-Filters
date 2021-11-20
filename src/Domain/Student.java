package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String studentId;
    protected String name;
    protected String department;
    protected ArrayList<String> completedCoursesList;
    public Student(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.studentId = stringTokenizer.nextToken();
    	this.name = stringTokenizer.nextToken() + " " + stringTokenizer.nextToken();
    	this.department = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {
    		this.completedCoursesList.add(stringTokenizer.nextToken());
    	}
    }
    public String toString() {
        String stringReturn = this.studentId + " " + this.name + " " + this.department;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " " + this.completedCoursesList.get(i).toString();
        }
        return stringReturn;
    }
    public boolean match(String studentId) { return this.studentId.equals(studentId); }
    public String getName() { return this.name;}
	public String getStudentId() {return studentId;}
	public String getDepartment() {return department;}
	public ArrayList<String> getCompletedCoursesList() {return completedCoursesList;}
}
