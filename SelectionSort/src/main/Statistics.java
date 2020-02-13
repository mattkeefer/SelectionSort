package main;
import java.util.*;

public class Statistics {

	private ArrayList<Double> grades;
	private int size;
	
	public Statistics(AllStudents a) {
		for(StudentInfo s : a.sortGrades()) {
			grades.add(s.getFinalAverage());
		}
		size = grades.size();
	}
	
	private double getMean() {
		double sum = 0;
		for(double d : grades) {
			sum += d;
		}
		return sum/grades.size();
	}
	
	private String getMedian() {
		if(size%2!=0) {
			return String.format("%d", grades.get(size/2));
		}
		double median = (grades.get(size/2-1)+grades.get(size/2))/2.0;
		if(median==(int)median) {
			return String.format("%d", (int)median);
		}
		return String.format("%.3f", median);
	}
	
	private String getMode() {
		ArrayList<Double> mode = new ArrayList<>();
		int modeCount = 1;
		int count;
		for(int i=0; i<size; i++) {
			count = 0; //resets count for each number
			for(int j=0; j<size; j++) { //if a value in the array matches the current value, add one to the count
				if(grades.get(i).equals(grades.get(j)) && !mode.contains(grades.get(i))) { //ensures each number is only counted once
					count++;
				}
			}
			if(count>modeCount) { //sets new modeCount, resets mode array list, adds num to mode array list
				mode.clear();
				mode.add(grades.get(i));
				modeCount = count;
			}
			else if(count==modeCount && modeCount>1) { //adds num to mode array list
				mode.add(grades.get(i));
			}
		}
		if(mode.isEmpty()) { //if no number occurs more than once in the array --> no mode
			return "None";
		}
		String out = "";
		for(double d : mode) { //formats output for mode
			if(d==mode.get(0)) {
				out += String.format("%.1f", d);
			}
			else {
				out += ", " + String.format("%.1f", d);
			}
		}
		out += " (" + modeCount + " occurences)"; //number of times a number appears in the array
		return out;
	}
	
	private String getDeviation() { //finds standard deviation
		double[] dev = new double[size];
		for(int i=0; i<size; i++) {
			dev[i] = Math.pow(grades.get(i)-getMean(), 2);
		}
		double sum = 0;
		for(double d : dev) {
			sum += d;
		}
		return String.format("%.3f", Math.sqrt(sum/size));
	}
	
	public String getInformation() {
		return "Mean: " + String.format("%.3f", getMean()) + "\nMedian: " + getMedian() + "\nMode: " + getMode() + "\nStandard Deviation: " + getDeviation();
	}
}