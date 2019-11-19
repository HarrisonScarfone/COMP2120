package lab9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class MainWindow {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private PeopleManager peopleManager;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		peopleManager = new PeopleManager();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 679, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 12, 304, 595);
		frame.getContentPane().add(scrollPane);
		
		String[] columns = {"Last Name", "First Name", "Date of Birth"};
		
		tableModel = new DefaultTableModel(columns, 0);
		
		peopleManager.loadRecords();
		populateTable();
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblLabDatabase = new JLabel("Lab 9 Database");
		lblLabDatabase.setFont(new Font("Dialog", Font.BOLD, 25));
		lblLabDatabase.setBounds(66, 12, 244, 40);
		frame.getContentPane().add(lblLabDatabase);
		
		JButton btnClearDatabase = new JButton("Clear Database");
		btnClearDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTable();
			}
		});
		
		btnClearDatabase.setBounds(12, 92, 137, 25);
		frame.getContentPane().add(btnClearDatabase);
		
		JButton btnLoadSaved = new JButton("Load Saved");
		btnLoadSaved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTable();
				peopleManager.loadRecords();
				populateTable();	
				tableModel.fireTableDataChanged();
			}
		});
		btnLoadSaved.setBounds(12, 161, 137, 25);
		frame.getContentPane().add(btnLoadSaved);
		
		JButton btnSaveCurrent = new JButton("Save Current");
		btnSaveCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				peopleManager.writeRecords();
			}
		});
		
		btnSaveCurrent.setBounds(12, 228, 137, 25);
		frame.getContentPane().add(btnSaveCurrent);
		
		JLabel lblByHarrisonScarfone = new JLabel("By: Harrison Scarfone Std.#:104900846");
		lblByHarrisonScarfone.setBounds(22, 592, 323, 15);
		frame.getContentPane().add(lblByHarrisonScarfone);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				peopleManager.addPerson(new Person(txtFirstName.getText(), txtLastName.getText(), 
						txtMonth.getText(), txtDay.getText(), txtYear.getText()));
				Object[] addThis = {txtLastName.getText(), txtFirstName.getText(), txtMonth.getText() 
						+ "-" + txtDay.getText() + "-" + txtYear.getText()};
				tableModel.addRow(addThis);
				tableModel.fireTableDataChanged();
			}
		});
		
		btnAddNew.setBounds(196, 397, 114, 25);
		frame.getContentPane().add(btnAddNew);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(12, 376, 124, 19);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setBounds(12, 429, 124, 19);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtDay = new JTextField();
		txtDay.setText("dd");
		txtDay.setBounds(118, 486, 80, 19);
		frame.getContentPane().add(txtDay);
		txtDay.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(12, 349, 94, 15);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(12, 402, 94, 15);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth (mm-dd-yyyy)");
		lblDateOfBirth.setBounds(12, 459, 213, 15);
		frame.getContentPane().add(lblDateOfBirth);
		
		txtMonth = new JTextField();
		txtMonth.setText("mm");
		txtMonth.setColumns(10);
		txtMonth.setBounds(12, 486, 80, 19);
		frame.getContentPane().add(txtMonth);
		
		txtYear = new JTextField();
		txtYear.setText("yyyy");
		txtYear.setColumns(10);
		txtYear.setBounds(230, 486, 80, 19);
		frame.getContentPane().add(txtYear);
		
		JButton btnDeleteSelectedRow = new JButton("Delete Selected Row");
		btnDeleteSelectedRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] selectedRows = table.getSelectedRows();
				for(int i=0; i<selectedRows.length; i++) {
					tableModel.removeRow(selectedRows[i]-i);
					peopleManager.removePerson(selectedRows[i]-i);				
				}
				tableModel.fireTableDataChanged();
			}
		});
		btnDeleteSelectedRow.setBounds(173, 92, 178, 25);
		frame.getContentPane().add(btnDeleteSelectedRow);
		
		JButton btnNewButton = new JButton("Generate Random");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i<100000; i++) {
					int month = (int) (Math.random()*11 + 1);
					int day = (int) (Math.random()*30 + 1);
					int year = (int) (Math.random()*69 + 1950);
					peopleManager.addPerson(new Person(
							Names.lastNames[(int)(Math.random()*Names.lastNames.length)],
							Names.firstNames[(int)(Math.random()*Names.firstNames.length)],
							"" + month,
							"" + day,
							"" + year));
				}
				populateTable();				
			}
		});
		btnNewButton.setBounds(173, 161, 178, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSortAscending = new JButton("Sort Ascending");
		btnSortAscending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				peopleManager.sortPeopleAscending();
				ArrayList<Person> temp = new ArrayList<>(peopleManager.getPeople());
				clearTable();
				peopleManager.setPeople(temp);
				populateTable();
				tableModel.fireTableDataChanged();
			}
		});
		
		btnSortAscending.setBounds(173, 228, 178, 25);
		frame.getContentPane().add(btnSortAscending);
		
		JButton btnSortDescending = new JButton("Sort Descending");
		btnSortDescending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				peopleManager.sortPeopleDescending();
				ArrayList<Person> temp = new ArrayList<>(peopleManager.getPeople());
				clearTable();
				peopleManager.setPeople(temp);
				populateTable();
				tableModel.fireTableDataChanged();
			}
		});
		btnSortDescending.setBounds(173, 291, 178, 25);
		frame.getContentPane().add(btnSortDescending);
	}
	
	public void populateTable(){
		for(Person p: peopleManager.getPeople()) {
			String firstName = p.getFirstName();
			String lastName = p.getLastName();
			String date = p.getBirthMonth() + "-" + p.getBirthDay() + "-" + p.getBirthYear();
			Object[] addThis = {lastName, firstName, date};
			tableModel.addRow(addThis);
		}
	}
	
	public void clearTable() {
		int numOfRows = table.getRowCount();
		for(int i=0; i<numOfRows; i++) {
			tableModel.removeRow(0);
		}
		peopleManager.clearPeople();
		tableModel.fireTableDataChanged();
	}
}
