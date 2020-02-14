package main;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BreezySwing.*;

public class AddDlg extends GBDialog {
	
	JLabel nameLbl = addLabel("Name", 1,1,1,1);
	JTextField name = addTextField("", 2,1,1,1);
	JLabel testLbl = addLabel("Test Score", 1,2,1,1);
	JTextField test = addTextField("", 2,2,1,1);
	JButton addTest = addButton("Add Test", 3,2,1,1);
	JLabel quizLbl = addLabel("Quiz Score", 1,3,1,1);
	JTextField quiz = addTextField("", 2,3,1,1);
	JButton addQuiz = addButton("Add Quiz", 3,3,1,1);
	JLabel hwLbl = addLabel("Homework Average", 1,4,1,1);
	JTextField hw = addTextField("", 2,4,1,1);
	JButton add = addButton("Add Student", 10,3,2,1);
	JButton exit = addButton("Exit", 10,1,2,1);
	
	AllStudents all;
	int testCount;
	int quizCount;
	double[] tests;
	double[] quizzes;
	double hwAvg;
	
	public AddDlg(JFrame frm, AllStudents a) throws FormatException {
		super(frm);
		all = a;
		testCount = 0;
		quizCount = 0;
		tests = new double[5];
		quizzes = new double[8];
		addTest.setEnabled(true);
		addQuiz.setEnabled(true);
		test.setEditable(true);
		quiz.setEditable(true);
		getContentPane().setBackground(new Color(217, 130, 176));
		setSize(800, 250);
		setTitle("Add Students");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button==exit) {
			dispose();
		}
		if(button==add) {
			try {
				if(testCount==0) {
					throw new FormatException("Please enter at least one test score.");
				}
				if(quizCount==0) {
					throw new FormatException("Please enter at least one quiz score.");
				}
				setHwAvg(hw.getText());
				StudentInfo s = new StudentInfo(name.getText().trim(), tests, testCount, quizzes, quizCount, hwAvg);
				clearFields();
				all.addStudent(s);
				dispose();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button==addTest) {
			try {
				addTest(test.getText());
				testLbl.setText(print(tests, testCount));
				if(testCount==5) {
					addTest.setEnabled(false);
					test.setEditable(false);
					quiz.grabFocus();
				}
				else {
					test.grabFocus();
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button==addQuiz) {
			try {
				addQuiz(quiz.getText());
				quizLbl.setText(print(quizzes, quizCount));
				if(quizCount==8) {
					addQuiz.setEnabled(false);
					quiz.setEditable(false);
					hw.grabFocus();
				}
				else {
					quiz.grabFocus();
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
	
	private void addTest(String str) throws FormatException {
		try {
			if(!str.trim().equals("")) {
				if(Double.parseDouble(str.trim())<0 || Double.parseDouble(str.trim())>100) {
					throw new FormatException("Test grade must be between 0-100.");
				}
				tests[testCount] = Double.parseDouble(str.trim());
				testCount++;
				test.setText("");
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid test input.");
		}
	}
	
	private void addQuiz(String str) throws FormatException {
		try {
			if(!str.trim().equals("")) {
				if(Double.parseDouble(str.trim())<0 || Double.parseDouble(str.trim())>100) {
					throw new FormatException("Quiz grade must be between 0-100.");
				}
				quizzes[quizCount] = Double.parseDouble(str.trim());
				quizCount++;
				quiz.setText("");
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid quiz input.");
		}
	}
	
	private void setHwAvg(String str) throws FormatException {
		try {
			if(str.trim().equals("")) {
				throw new FormatException("Invalid homework average.");
			}
			if(Double.parseDouble(str.trim())<0 || Double.parseDouble(str.trim())>100) {
				throw new FormatException("Homework average must be between 0-100.");
			}
			hwAvg = Double.parseDouble(str.trim());
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid homework average.");
		}
	}
	
	private void clearFields() {
		name.setText("");
		test.setText("");
		quiz.setText("");
		hw.setText("");
	}
	
	private String print(double[] arr, int length) {
		String out = String.format("%.1f", arr[0]);
		for(int i=1; i<length; i++) {
			out += ", " + String.format("%.1f", arr[i]);
		}
		return out;
	}
}