package main;
import java.util.*;

public class AllStudents {

	ArrayList<StudentInfo> students;
	
	public AllStudents() {
		students = new ArrayList<StudentInfo>();
	}
	
	public void addStudent(StudentInfo s) {
		students.add(s);
	}
	
	public ArrayList<StudentInfo> sortGrades() {
		int min = 0;
		for(int i=1; i<students.size(); i++) {
			for(int j=i+1; i<students.size(); j++) {
				if(students.get(j).getFinalAverage() < students.get(min).getFinalAverage()) {
					min = j;
				}
			}
			if(min != i) {
				StudentInfo holder = students.get(min);
				students.set(min, students.get(i));
				students.set(i, holder);
			}
		}
		return students;
	}
	
	public ArrayList<StudentInfo> sortNames() {
		int min = 0;
		for(int i=1; i<students.size(); i++) {
			for(int j=i+1; i<students.size(); j++) {
				if(students.get(j).compareTo(students.get(min))<0) {
					min = j;
				}
			}
			if(min != i) {
				StudentInfo holder = students.get(min);
				students.set(min, students.get(i));
				students.set(i, holder);
			}
		}
		return students;
	}
}