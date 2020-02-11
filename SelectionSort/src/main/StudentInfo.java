package main;

import java.util.Random;

public class StudentInfo implements Comparable {
	
	private String name;
	private double[] tests;
	private int testCount;
	private double[] quizzes;
	private int quizCount;
	private double hwAvg;
	
	public StudentInfo(String nm) throws FormatException {
		tests = new double[5];
		quizzes = new double[8];
		if(nm.trim().equals("")) {
			throw new FormatException("Name cannot be blank.");
		}
		else {
			name = nm;
		}
		testCount = 0;
		quizCount = 0;
	}
	
	public StudentInfo(String nm,double hw) {
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
	
	public void addTest(double d) {
		tests[testCount] = d;
		testCount++;
	}
	
	public void addQuiz(double d) {
		quizzes[quizCount] = d;
		quizCount++;
	}
	
	public void addTest(String str) throws FormatException {
		try {
			if(!str.trim().equals("")) {
				tests[testCount] = Double.parseDouble(str.trim());
				testCount++;
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid test input.");
		}
	}
	
	public void addQuiz(String str) throws FormatException {
		try {
			if(!str.trim().equals("")) {
				quizzes[quizCount] = Double.parseDouble(str.trim());
				quizCount++;
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid quiz input.");
		}
	}
	
	public void setHwAvg(String str) throws FormatException {
		try {
			if(str.trim().equals("")) {
				throw new FormatException("Invalid homework average.");
			}
			if(Double.parseDouble(str.trim())<0 || Double.parseDouble(str.trim())>100) {
				//ERROR
			}
			hwAvg = Double.parseDouble(str.trim());
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid homework average.");
		}
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