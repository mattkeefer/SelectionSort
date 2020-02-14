package main;
import java.util.*;
import java.util.Random;

public class StudentInfo implements Comparable {
	
	private String name;
	private ArrayList<Double> tests;
	private int testCount;
	private ArrayList<Double> quizzes;
	private int quizCount;
	private double hwAvg;
	
	public StudentInfo(String nm, double[] t, int tCount, double[] q, int qCount, double hw) throws FormatException {
		tests = new ArrayList<>();
		quizzes = new ArrayList<>();
		testCount = tCount;
		quizCount = qCount;
		for(int i=0; i<testCount; i++) {
			tests.add(t[i]);
		}
		for(int i=0; i<quizCount; i++) {
			quizzes.add(q[i]);
		}
		if(nm.trim().equals("")) {
			throw new FormatException("Name cannot be blank.");
		}
		else {
			name = nm;
		}
		hwAvg = hw;
	}
	
	public double getHwAvg() {
		return hwAvg;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTestAvg() {
		double sum = 0;
		for(double d : tests) {
			sum += d;
		}
		return sum/testCount;
	}
	
	public double getQuizAvg() {
		double sum = 0;
		for(double d : quizzes) {
			sum += d;
		}
		return sum/quizCount;
	}
	
	public double getFinalAverage() {
		return 0.5*getTestAvg() + 0.3*getQuizAvg() + 0.2*hwAvg;
	}
	
	public int compareTo(Object obj) {
		return name.toLowerCase().compareTo(((StudentInfo)obj).getName().toLowerCase());
	}
}