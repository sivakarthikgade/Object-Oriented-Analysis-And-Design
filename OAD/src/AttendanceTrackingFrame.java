import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AttendanceTrackingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private String[] selectionData = {"SELECT ONE", "Class1 (02-11-2014)", "Class1 (04-16-2014)", "Class2 (03-26-2014)", "Class2 (05-12-2014)"};
	private String[][] selectionDataValues = {{"001", "2014_02_11"}, {"001", "2014_04_16"}, {"002", "2014_03_26"}, {"002", "2014_05_12"}};
	private JTable table;
	private JPanel panel;
	private JScrollPane scroll;
	private JButton okButton;
	private JButton submitButton;
	private JLabel selectionListLabel;
	private JComboBox<String> selectionList;

	public void searchScreen() {
	    if(panel != null) {
	    	getContentPane().remove(panel);
	    }
		panel = new JPanel();
	    panel.setLayout(null);

	    selectionListLabel = new JLabel("ATTENDANCE RECORD: ");
	    selectionListLabel.setBounds(300, 200, 150, 30);
	    selectionListLabel.setForeground(Color.black);
	    panel.add(selectionListLabel);
	    
	    selectionList = new JComboBox<String>();
	    for(int i = 0; i < selectionData.length; i++) {
	    	selectionList.addItem(selectionData[i]);
	    }
	    selectionList.setBounds(450, 200, 150, 30);
	    panel.add(selectionList);
	    
	    submitButton = new JButton();
    	submitButton.setText("SUBMIT");
    	submitButton.setBounds(400, 300, 100, 50);
    	submitButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			int index = selectionList.getSelectedIndex();
    			if(index > 0) {
    				displayRecord(selectionDataValues[index-1][0], selectionDataValues[index-1][1]);
    			}
    		}
    	});
    	panel.add(submitButton);
	    getContentPane().add(panel);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Attendance Tracking System");
	    setSize(900, 900);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	private void displayAttendanceData(Object[][] data) {
	
	    if(panel != null) {
	    	getContentPane().remove(panel);
	    }
		panel = new JPanel();
	    panel.setLayout(null);
	    final String[] columnNames = {"Name", "Attendance"};

	    table = new JTable(data, columnNames);
	    table.disable();
	    scroll = new JScrollPane(table);
	    scroll.setBounds(0, 0, 900, 725);

	    okButton = new JButton();
	    okButton.setText("OK");
	    okButton.setBounds(400, 750, 100, 60);
	    okButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	searchScreen();
	        }
	    });

	    if(submitButton != null)
	    	panel.remove(submitButton);
	    panel.add(scroll);
	    panel.add(okButton);
	
	    getContentPane().add(panel);
	
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Attendance Tracking System");
	    setSize(900, 900);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}

	public void displayRecord(String classID, String date) {
		AttendanceSystemRequestController ctlr = new AttendanceSystemRequestController();
		final Object[][] data = ctlr.getAttendanceRecord(classID, date);
		displayAttendanceData(data);
	}

}