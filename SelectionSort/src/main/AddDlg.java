package main;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import BreezySwing.*;

public class AddDlg extends GBDialog {
	
	JLabel nameLbl = addLabel("Name", 1,1,1,1);
	JTextField name = addTextField("", 2,1,1,1);
	JLabel testLbl = addLabel("Test Scores", 1,2,1,1);
	DoubleField test1 = addDoubleField(0, 2,2,1,1);
	DoubleField test2 = addDoubleField(0, 3,2,1,1);
	DoubleField test3 = addDoubleField(0, 4,2,1,1);
	DoubleField test4 = addDoubleField(0, 5,2,1,1);
	DoubleField test5 = addDoubleField(0, 6,2,1,1);
	
	public AddDlg(JFrame frm, AllStudents a) throws FormatException {
		super(frm);
		
		setSize(800, 650);
		setTitle("Add Students");
		setVisible(true);
	}
}
