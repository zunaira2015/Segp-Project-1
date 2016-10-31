package raat2;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;
import raat2.Login;

public class searching {
	
	public JTable search(JTable jTable , JTextField  jtfFilter, JPanel Listofstudents, String columnname ) throws SQLException{
	
	String connectionURL = "jdbc:mysql://localhost/project";//
	Connection conn=null;//
	Statement stmt=null;//
	ResultSet rs=null;//
	JTableHeader tableHeader;//
	String a=jtfFilter.getText();
	
	
	
	conn = DriverManager.getConnection(connectionURL,"root","");//
	stmt = conn.createStatement();//
	if(columnname.equals("Name"))
	{
		System.out.println("its entering name");
		rs = stmt.executeQuery(
				"select * from student_list where Name like '"+a+"%'"+";");//
		
			System.out.println(rs);

		
				
		System.out.println("select * from student_list where Name like '"+a+"%'"+";");
	
	}
	if(columnname.equals("UOB"))
	{
		rs = stmt.executeQuery(
				"select * from student_list where UOB like "+a+";");//
	
	}
	if(columnname.equals("Year"))
	{
		rs = stmt.executeQuery(
				"select * from student_list where Year like "+a+";");//
		System.out.println(rs);
	
	}
	if(columnname.equals("Search by"))
	{
		rs = stmt.executeQuery("select * from student_list");
	
		System.out.println(rs);
	
	}
		
	jTable.setModel(DbUtils.resultSetToTableModel(rs));

	JTable table = new JTable();
	Listofstudents.setLayout(new BorderLayout(0, 0));
	
	table = new JTable();
	table.setModel(DbUtils.resultSetToTableModel(rs));
	tableHeader = table.getTableHeader();


	table.setEnabled(false);

	
	JScrollPane tableContainer = new JScrollPane(table);
	Listofstudents.add(tableContainer);
	
	return jTable;
	}
	
	
	public JTable searchteachers(JTable jTable , JTextField  jtfFilter, JPanel listofpas, String columnname ) throws SQLException{
		
		String connectionURL = "jdbc:mysql://localhost/project";//
		Connection conn=null;//
		Statement stmt=null;//
		ResultSet rs=null;//
		JTableHeader tableHeader;//
		String a=jtfFilter.getText();
		
		
		
		conn = DriverManager.getConnection(connectionURL,"root","");//
		stmt = conn.createStatement();//
		if(columnname.equals("Name"))
		{
			System.out.println("its entering name");
			rs = stmt.executeQuery(
					"select * from teachers_Data where Name like '"+a+"%'"+";");//
			
				System.out.println(rs);

			
					
			System.out.println("select * from teachers_Data where Name like '"+a+"%'"+";");
		
		}
		if(columnname.equals("Department"))
		{
			rs = stmt.executeQuery(
					"select * from teachers_Data where Department like '"+a+"%'"+";");//
		
		}
		if(columnname.equals("Search by"))
		{
			rs = stmt.executeQuery("select * from teachers_Data");
		
			System.out.println(rs);
		
		}
			
		jTable.setModel(DbUtils.resultSetToTableModel(rs));

		JTable table = new JTable();
		listofpas.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		tableHeader = table.getTableHeader();


		table.setEnabled(false);

		
		JScrollPane tableContainer = new JScrollPane(table);
		listofpas.add(tableContainer);
		
		return jTable;
		}
	
public JTable searchgroups(JTable jTable , JTextField  jtfFilter, JPanel listofgroups, String columnname ) throws SQLException{
		
		String connectionURL = "jdbc:mysql://localhost/project";//
		Connection conn=null;//
		Statement stmt=null;//
		ResultSet rs=null;//
		JTableHeader tableHeader;//
		String a=jtfFilter.getText();
		
		
		
		conn = DriverManager.getConnection(connectionURL,"root","");//
		stmt = conn.createStatement();//
		
		if(columnname.equals("Group_no"))
		{
			rs = stmt.executeQuery(
					"select * from groups where Group_no like "+a+";");//
			System.out.println(rs);
		
		}
		
		if(columnname.equals("Search by"))
		{
			rs = stmt.executeQuery("select * from groups");
		
			System.out.println(rs);
		
		}
			
		jTable.setModel(DbUtils.resultSetToTableModel(rs));

		JTable table = new JTable();
		listofgroups.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		tableHeader = table.getTableHeader();


		table.setEnabled(false);

		
		JScrollPane tableContainer = new JScrollPane(table);
		listofgroups.add(tableContainer);
		
		return jTable;
		}
	
}
