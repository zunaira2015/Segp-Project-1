package raat2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import org.apache.poi.util.SystemOutLogger;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField UOBtextfield;
	private JTextField Nametextfield;
	private JTextField Yeartextfield;
	private JTextField Emailtextfield;
	private JTextField Contacttextfield;
	
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		Login.createtable();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void save_changes() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost/project","root","");
		Statement stmt=con.createStatement();
		try {
					String q = "UPDATE student_list set Year =" + Yeartextfield.getText() + ", contact =" + Contacttextfield.getText() + " where UOB ="+ UOBtextfield.getText()+"";
					stmt.executeUpdate(q);
		} catch (SQLException e) {
			}
		ResultSet rs = stmt.executeQuery("select * from student_list");
		Login.table.setModel(DbUtils.resultSetToTableModel(rs));

		JTable table = new JTable();
		Login.Listofstudents.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		Login.tableHeader = table.getTableHeader();


		table.setEnabled(false);

		
		JScrollPane tableContainer = new JScrollPane(table);
		Login.Listofstudents.add(tableContainer);
		con.close();
		
	}

	JTable jt=new JTable();
	public update() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 429, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		UOBtextfield = new JTextField();
		UOBtextfield.setBounds(150, 51, 86, 20);
		panel.add(UOBtextfield);
		UOBtextfield.setColumns(10);
		
		JLabel UOB = new JLabel("UOB");
		UOB.setBounds(62, 51, 46, 14);
		panel.add(UOB);
		
		JLabel YEAR = new JLabel("Year");
		YEAR.setBounds(62, 94, 46, 14);
		panel.add(YEAR);
		
		JLabel Email = new JLabel("Email");
		Email.setBounds(62, 137, 46, 14);
		panel.add(Email);
		
		JLabel Contact = new JLabel("Contact");
		Contact.setBounds(62, 181, 46, 14);
		panel.add(Contact);
		
		JLabel name = new JLabel("Name");
		name.setBounds(62, 22, 46, 14);
		panel.add(name);
		
		Nametextfield = new JTextField();
		Nametextfield.setBounds(150, 19, 86, 20);
		panel.add(Nametextfield);
		Nametextfield.setColumns(10);
		
		Yeartextfield = new JTextField();
		Yeartextfield.setBounds(150, 91, 86, 20);
		panel.add(Yeartextfield);
		Yeartextfield.setColumns(10);
		
		Emailtextfield = new JTextField();
		Emailtextfield.setBounds(150, 134, 86, 20);
		panel.add(Emailtextfield);
		Emailtextfield.setColumns(10);
		
		Contacttextfield = new JTextField();
		Contacttextfield.setBounds(150, 178, 86, 20);
		panel.add(Contacttextfield);
		Contacttextfield.setColumns(10);
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					save_changes();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}	
				setVisible(false);
			}
		});
		save.setBounds(85, 222, 89, 23);
		panel.add(save);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			}
		});
		cancel.setBounds(194, 222, 89, 23);
		panel.add(cancel);
	}
}
