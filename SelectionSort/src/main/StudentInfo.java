package main;

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
	
	public void addTest(String str) throws FormatException {
		try {
			if(str.trim().equals("")) {
				throw new FormatException("");
			}
			tests[testCount] = Double.parseDouble(str.trim());
			testCount++;
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid test input.");
		}
	}
	
	public void addQuiz(String str) throws FormatException {
		try {
			if(str.trim().equals("")) {
				throw new FormatException("");
			}
			quizzes[quizCount] = Double.parseDouble(str.trim());
			quizCount++;
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