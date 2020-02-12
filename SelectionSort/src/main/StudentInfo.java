package main;

import java.util.Random;

public class StudentInfo implements Comparable {
	
	private String name;
	private double[] tests;
	private int testCount;
	private double[] quizzes;
	private int quizCount;
	private double hwAvg;
	
	public StudentInfo(String nm, double[] t, double[] q, double hw) throws FormatException {
		tests=new double[5];
		quizzes=new double[8];
		testCount=0;
		quizCount=0;
		for(double d : t) {
			addTest(d);
		}
		for(double d : q) {
			addQuiz(d);
		}
		if(nm.trim().equals("")) {
			throw new FormatException("Name cannot be blank.");
		}
		else {
			name = nm;
		}
		hwAvg = hw;
	}
	
	public StudentInfo(String nm, double hw) {
		name=nm;
		tests=new double[5];
		quizzes=new double[8];
		testCount=0;
		quizCount=0;
		hwAvg = hw;
		Random r = new Random();
		for(int i=0;i<5;i++) {
			addTest(50 + (100 - 50) * r.nextDouble());
		}
		for(int i=0;i<8;i++) {
			addQuiz(50 + (100 - 50) * r.nextDouble());
		}
	}
	
	private void addTest(double d) {
		tests[testCount] = d;
		testCount++;
	}
	
	private void addQuiz(double d) {
		quizzes[quizCount] = d;
		quizCount++;
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