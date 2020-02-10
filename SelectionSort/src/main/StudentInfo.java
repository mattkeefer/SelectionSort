package main;

public class StudentInfo implements Comparable {
	
	private String name;
	private double[] tests;
	private int testCount;
	private double[] quizzes;
	private int quizCount;
	private double hwAvg;
	
	public StudentInfo(String nm) {
		tests = new double[5];
		quizzes = new double[8];
		name = nm;
		testCount = 0;
		quizCount = 0;
	}
	
	public void addTest(double d) {
		tests[testCount] = d;
		testCount++;
	}
	
	public void addQuiz(double d) {
		quizzes[quizCount] = d;
		quizCount++;
	}
	
	public void setHwAvg(double d) {
		hwAvg = d;
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