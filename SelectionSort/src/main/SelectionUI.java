package main;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BreezySwing.*;

public class SelectionUI extends GBFrame {

	JPanel output = addPanel(1,1,4,1);
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	JButton add = addButton("Add Students", 2,1,1,1);
	JLabel sortLbl = addLabel("Sort By:", 2,2,1,1);
	//ADD RADIO BUTTONS
	
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
		updateTable();
	}
	
	public static void main(String[] args) {
		JFrame frm = new SelectionUI();
		frm.setTitle("Selection Sort");
		frm.setSize(800, 650);
		frm.setVisible(true);
		frm.getContentPane().setBackground(new Color(204, 78, 92));
	}
	
	public void buttonClicked(JButton button) {
		if(button==add) {
			try {
				AddDlg ad = new AddDlg(this, a);
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
	
	private void updateTable() {
		model.setRowCount(0);
		for(StudentInfo s : a.getStudentsArray()) {
			addStudentToTable(s);
		}
		table.repaint();
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