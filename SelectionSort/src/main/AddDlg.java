package main;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BreezySwing.*;

public class AddDlg extends GBDialog {
	
	JLabel nameLbl = addLabel("Name", 1,1,1,1);
	JTextField name = addTextField("", 2,1,1,1);
	JLabel testLbl = addLabel("Test Scores", 1,2,1,1);
	JTextField test1 = addTextField("", 2,2,1,1);
	JTextField test2 = addTextField("", 3,2,1,1);
	JTextField test3 = addTextField("", 4,2,1,1);
	JTextField test4 = addTextField("", 5,2,1,1);
	JTextField test5 = addTextField("", 6,2,1,1);
	JLabel quizLbl = addLabel("Quiz Scores", 1,3,1,1);
	JTextField quiz1 = addTextField("", 2,3,1,1);
	JTextField quiz2 = addTextField("", 3,3,1,1);
	JTextField quiz3 = addTextField("", 4,3,1,1);
	JTextField quiz4 = addTextField("", 5,3,1,1);
	JTextField quiz5 = addTextField("", 6,3,1,1);
	JTextField quiz6 = addTextField("", 7,3,1,1);
	JTextField quiz7 = addTextField("", 8,3,1,1);
	JTextField quiz8 = addTextField("", 9,3,1,1);
	JLabel hwLbl = addLabel("Homework Average", 1,4,1,1);
	JTextField hw = addTextField("", 2,4,1,1);
	JButton add = addButton("Add", 10,1,2,1);
	JButton exit = addButton("Exit", 10,3,2,1);
	
	AllStudents all;
	
	
	public AddDlg(JFrame frm, AllStudents a) throws FormatException {
		super(frm);
		all = a;
		setSize(800, 650);
		setTitle("Add Students");
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button==exit) {
			dispose();
		}
		else {
			try {
				StudentInfo s = new StudentInfo(name.getText().trim());
				s.addTest(test1.getText());
				s.addTest(test2.getText());
				s.addTest(test3.getText());
				s.addTest(test4.getText());
				s.addTest(test5.getText());
				s.addQuiz(quiz1.getText());
				s.addQuiz(quiz2.getText());
				s.addQuiz(quiz3.getText());
				s.addQuiz(quiz4.getText());
				s.addQuiz(quiz5.getText());
				s.addQuiz(quiz6.getText());
				s.addQuiz(quiz7.getText());
				s.addQuiz(quiz8.getText());
				s.setHwAvg(hw.getText());
				clearFields();
				all.addStudent(s);
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
	
	private void clearFields() {
		name.setText("");
		test1.setText("");
		test2.setText("");
		test3.setText("");
		test4.setText("");
		test5.setText("");
		quiz1.setText("");
		quiz2.setText("");
		quiz3.setText("");
		quiz4.setText("");
		quiz5.setText("");
		quiz6.setText("");
		quiz7.setText("");
		quiz8.setText("");
		hw.setText("");
	}
}