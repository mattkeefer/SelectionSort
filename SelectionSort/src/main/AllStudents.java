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
	
	public int getSize() {
		return students.size();
	}
	
	public ArrayList<StudentInfo> getStudentsArray() {
		return students;
	}
	
	public ArrayList<StudentInfo> sortGrades() {
		for(int i=0; i<students.size()-1; i++) {
			int max = i;
			for(int j=i+1; j<students.size(); j++) {
				if(students.get(j).getFinalAverage() > students.get(max).getFinalAverage()) {
					max = j;
				}
			}
			if(max != i) {
				StudentInfo holder = students.get(max);
				students.set(max, students.get(i));
				students.set(i, holder);
			}
		}
		return students;
	}
	
	public ArrayList<StudentInfo> sortNames() {
		for(int i=0; i<students.size()-1; i++) {
			int min = i;
			for(int j=i+1; j<students.size(); j++) {
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