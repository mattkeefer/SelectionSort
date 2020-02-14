package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import BreezySwing.*;

public class SelectionUI extends GBFrame {

	JPanel output = addPanel(1,1,4,1);
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	JButton add = addButton("Add Student", 2,1,1,1);
	JLabel sortLbl = addLabel("Sort By:", 2,2,1,1);
	ButtonGroup sortMethod = new ButtonGroup();
	JRadioButton name = addRadioButton("Name", 2,3,1,1);
	JRadioButton grade = addRadioButton("Grade", 2,4,1,1);
	JTextArea out = addTextArea("", 3,1,4,1);
	
	AllStudents a = new AllStudents();
	
	public SelectionUI() {
		String[] columnNames = {"Name",
	            "Test Average",
	            "Quiz Average",
	            "Homework Average",
	            "Final Average"};
		data = new String[25][5];
		output.setLayout(new BorderLayout());
		table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		JScrollPane scrollpane = new JScrollPane(table);
		output.add(scrollpane);
		table.disable();
		out.setEditable(false);
		out.setBackground(new Color(217, 130, 176));
		out.setForeground(new Color(255, 255, 255));
		out.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
		table.setForeground(new Color(217, 130, 176));
		table.setFont(new Font("Arial", Font.TRUETYPE_FONT, 13));
		sortMethod.add(name);
		sortMethod.add(grade);
		name.addChangeListener(cl);
		grade.addChangeListener(cl);
	}
	
	private ChangeListener cl = new ChangeListener() {
    	@Override
    	public void stateChanged(ChangeEvent e) {
    		JRadioButton source = (JRadioButton) e.getSource();
    		if(source==name && name.isSelected()) {
    			updateTable(a.sortNames());
			}
			if(source==grade && grade.isSelected()) {
				updateTable(a.sortGrades());
			}
    	}
    };
	
	public static void main(String[] args) {
		JFrame frm = new SelectionUI();
		frm.setTitle("Selection Sort");
		frm.setSize(800, 450);
		frm.setVisible(true);
		frm.getContentPane().setBackground(new Color(217, 130, 176));
	}
	
	public void buttonClicked(JButton button) {
		if(button==add) {
			try {
				if(a.getStudentsArray().size()==15) {
					throw new FormatException("Max of 15 students.");
				}
				AddDlg ad = new AddDlg(this, a);
				if(a.getStudentsArray().size()>0) {
					updateTable(a.sortNames());
					name.setSelected(true);
					grade.setSelected(false);
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
	
	private void updateTable(ArrayList<StudentInfo> list) {
		model.setRowCount(0);
		for(StudentInfo s : list) {
			addStudentToTable(s);
		}
		table.repaint();
		Statistics stats = new Statistics(a);
		out.setText(stats.getInformation());
	}
	
	private void addStudentToTable(StudentInfo s) {
		String[] row = new String[5];
		row[0] = s.getName();
		row[1] = String.format("%.1f", s.getTestAvg());
		row[2] = String.format("%.1f", s.getQuizAvg());
		row[3] = String.format("%.1f", s.getHwAvg());
		row[4] = String.format("%.1f", s.getFinalAverage());
		model.addRow(row);
	}
}