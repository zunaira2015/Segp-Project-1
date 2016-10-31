package raat2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import TestTableSortFilter.TestTableSortFilter;
import net.proteanit.sql.DbUtils;

import java.awt.Choice;
import java.awt.TextArea;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField t;
	private JPasswordField passwordField;
	static Login l;
	private JTextField textField_1;
	JPanel email;
	JPanel signin;
	JPanel menuebar;
	JPanel home;
	static JPanel Listofstudents;
	JPanel listofpas;
	JPanel listofgroups;
	private JTextField txtListofstudents;
	private JTextField txtListofpas;
	private JTextField txtListofgroupsandpas;
	JButton btnSignIn;
	String y="sso";
	JLabel lblNewLabel;
	
	
	static String connectionURL = "jdbc:mysql://localhost/project";//
	static private Connection conn=null;//
	static private Statement stmt=null;//
	static private ResultSet rs=null;//
	public static int columnCount;//
	public static JTable table;//
	public static TableColumn column = null;//
	static private Connection conn1=null;//
	static private Statement stmt1=null;//
	static private ResultSet rs1=null;//
	public static JTable table1;//
	JPanel lpsouthpanel ;
	JPanel lsnorthpanel;
	JPanel lpnorthpanel;
	JPanel lgnorthpanel;
	static JTableHeader tableHeader;
	static JTableHeader tableHeader1;
	private JTextField lstextfield;
	private JTextField lptextfield;
	private JTextField lgtextfield;
	JTable table0;
	static JScrollPane tableContainer;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
public static void createtable() throws SQLException{
	table = new JTable();
	Listofstudents.setLayout(new BorderLayout(0, 0));
//	JScrollPane tableContainer = new JScrollPane(table);
	
	conn = DriverManager.getConnection(connectionURL,"root","");
	stmt = conn.createStatement();


	rs = stmt.executeQuery("select * from student_list");
	
	table = new JTable();
	table.setModel(DbUtils.resultSetToTableModel(rs));
	tableHeader = table.getTableHeader();
	//Listofstudents.setLayout(new BorderLayout(0, 0));

	table.setEnabled(false);
	//tableHeader.setReorderingAllowed(false);
	
	tableContainer = new JScrollPane(table);
	Listofstudents.add(tableContainer);
	
}

	
	public static void refreshtable(){
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		tableHeader = table.getTableHeader();
		Listofstudents.setLayout(new BorderLayout(0, 0));

		table.setEnabled(false);
		//tableHeader.setReorderingAllowed(true);
		
		JScrollPane tableContainer = new JScrollPane(table);
		Listofstudents.add(tableContainer);
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					l=new Login();
					l.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		setForeground(Color.LIGHT_GRAY);
				ImageIcon img=new ImageIcon("G:/year 2/pdf/resources/download.jpg");
	    setIconImage(img.getImage());
		setTitle("PAT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnForgetPassword = new JButton("Forget password?");
		btnForgetPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		
		
				home = new JPanel();
				home.setBounds(0, 51, 694, 313);
				contentPane.add(home);
				home.setLayout(null);
			
				JLabel lblPersonalAdvisorTutoring = DefaultComponentFactory.getInstance().createTitle("PERSONAL ACADEMIC TUTORING SYSTEM");
				lblPersonalAdvisorTutoring.setForeground(new Color(0, 0, 128));
				lblPersonalAdvisorTutoring.setDisplayedMnemonic('c');
				lblPersonalAdvisorTutoring.setBackground(Color.GRAY);
				lblPersonalAdvisorTutoring.setFont(new Font("Tekton Pro Ext", Font.BOLD, 21));
				lblPersonalAdvisorTutoring.setBounds(36, 21, 534, 55);
				home.add(lblPersonalAdvisorTutoring);
						home.setVisible(false);

		signin = new JPanel();
		signin.setBounds(0, 0, 694, 364);
		contentPane.add(signin);
		signin.setForeground(new Color(0, 0, 0));
		signin.setLayout(null);
		


		btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d=t.getText();
String password=new String (passwordField.getPassword());
//System.out.println(password);

				if((d.equals("sso@namal.edu.pk"))&&(password.equals("sso"))){

					menuebar.setVisible(true);
					signin.setVisible(false);
					home.setVisible(true);

				}
				else{
					lblNewLabel.setVisible(true);
				}

			}
		});


		btnSignIn.setBounds(163, 180, 89, 23);
		signin.add(btnSignIn);

		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(60, 77, 95, 14);
		signin.add(lblUserName);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(70, 108, 100, 14);
		signin.add(lblPassword);

		t = new JTextField();

		//mytextField.addActionListener(this);


		t.setBounds(163, 76, 86, 20);
		signin.add(t);
		t.setColumns(10);
		//String y=(textField.getText());

		passwordField = new JPasswordField();
		passwordField.setBounds(163, 107, 89, 20);
		signin.add(passwordField);

		JLabel lblForgetPassword = new JLabel("Forget password??");
		lblForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				email.setVisible(true);
				signin.setVisible(false);
			}
		});
		lblForgetPassword.setBounds(163, 133, 126, 14);
		signin.add(lblForgetPassword);

		lblNewLabel = new JLabel("**WRONG USERNAME OR PASSWORD**");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 34, 283, 14);
		signin.add(lblNewLabel);
		lblNewLabel.setVisible(false);



		email = new JPanel();
		email.setBounds(0, 0, 694, 364);
		contentPane.add(email);
		email.setVisible(false);
		email.setLayout(null);


		JLabel lblPleaseEnterYour = new JLabel("PLease enter your email id to retrieve your password:");
		lblPleaseEnterYour.setBounds(27, 45, 378, 34);
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		email.add(lblPleaseEnterYour);

		JLabel lblEmailId = new JLabel("Email id:");
		lblEmailId.setBounds(27, 106, 82, 22);
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		email.add(lblEmailId);

		textField_1 = new JTextField();
		textField_1.setBounds(83, 108, 156, 20);
		email.add(textField_1);
		textField_1.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin.setVisible(true);
				email.setVisible(false);
				eMail em=new eMail();
				System.out.println(textField_1.getText());
				em.senteMail(textField_1.getText());
			//	JOptionPane.showMessageDialog(null, "E-mail sent");
			}  
		});
		btnOk.setBounds(83, 181, 89, 23);
		email.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(196, 181, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin.setVisible(true);
				email.setVisible(false);
			}
		});
		email.add(btnCancel);
		ButtonGroup toggle_group=new ButtonGroup();

		menuebar = new JPanel();
		menuebar.setBounds(0, 0, 694, 52);
		contentPane.add(menuebar);
		menuebar.setVisible(false);
		menuebar.setLayout(new GridLayout(0,5, 0, 0));
		JToggleButton tglbtnHome = new JToggleButton("Home");
		tglbtnHome.setSelected(true);
		tglbtnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(true);
				lsnorthpanel.setVisible(false);
				lpnorthpanel.setVisible(false);
			}
		});
		menuebar.add(tglbtnHome);

		JToggleButton tglbtnListOfStudents = new JToggleButton("List of students");
		tglbtnListOfStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//home.setEnabled(false);
				//home.setFocusable(false);
				//home.disable();
				home.enable(true);
				Listofstudents.setVisible(true);
				home.setVisible(false);
				lsnorthpanel.setVisible(true);
				lpnorthpanel.setVisible(false);
				lgnorthpanel.setVisible(false);
			}
		});
		menuebar.add(tglbtnListOfStudents);

		JToggleButton tglbtnListOfPas = new JToggleButton("List of PAs");
		tglbtnListOfPas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofpas.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);
				lpnorthpanel.setVisible(true);
lsnorthpanel.setVisible(false);
lgnorthpanel.setVisible(false);
				//	Listofstudents.setVisible(true);
				//home.setVisible(false);

			}
		});
		menuebar.add(tglbtnListOfPas);

		JToggleButton tglbtnListOfGroups = new JToggleButton("List of Groups");
		tglbtnListOfGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofgroups.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);
				listofpas.setVisible(false);
				lpnorthpanel.setVisible(false);
				lsnorthpanel.setVisible(false);
				lgnorthpanel.setVisible(true);
			}
		});
		menuebar.add(tglbtnListOfGroups);
		toggle_group.add(tglbtnHome);
		toggle_group.add(tglbtnListOfGroups);
		toggle_group.add(tglbtnListOfPas);
		toggle_group.add(tglbtnListOfStudents);
		
		JLabel logoutlabel = new JLabel("LOGOUT");
		logoutlabel.setVerticalAlignment(SwingConstants.TOP);
		logoutlabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				signin.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);
				listofpas.setVisible(false);
				listofgroups.setVisible(false);
				menuebar.setVisible(false);
				lblNewLabel.setVisible(false);
				t.setText(null);
				passwordField.setText(null);
				
				
			}
		});
		menuebar.add(logoutlabel);

		Listofstudents = new JPanel();
		Listofstudents.setBounds(0, 51, 694, 313);
		contentPane.add(Listofstudents);
		
		createtable();
	// creating table of list of student	
	/*	table = new JTable();
		Listofstudents.setLayout(new BorderLayout(0, 0));
	//	JScrollPane tableContainer = new JScrollPane(table);
		
		conn = DriverManager.getConnection(connectionURL,"root","");
		stmt = conn.createStatement();


		rs = stmt.executeQuery("select * from student_list");
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		tableHeader = table.getTableHeader();
		//Listofstudents.setLayout(new BorderLayout(0, 0));

		table.setEnabled(false);
		//tableHeader.setReorderingAllowed(false);
		
		JScrollPane tableContainer = new JScrollPane(table);
		Listofstudents.add(tableContainer);*/
		
		
		lsnorthpanel = new JPanel();
		Listofstudents.add(lsnorthpanel, BorderLayout.NORTH);
		lsnorthpanel.setVisible(false);
		JButton lsDownload = new JButton("Download");
		
		lsDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Document student_list = new Document();
			        try {
						PdfWriter.getInstance(student_list, new FileOutputStream("student_list.pdf"));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        student_list.open(); 
			        PdfPTable students = new PdfPTable(5);
			        
			        PdfPCell table_cell ;
			        ResultSet query_set=null;
			        try {
						query_set = stmt.executeQuery("Show columns from student_list");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        
			        try {
						while(query_set.next()){
						//	String name=column_name.getString("host");
							table_cell=new PdfPCell(new Phrase("Nmae"));
							 students.addCell(table_cell);
						//	String contact=column_name.getString("Db");
							table_cell=new PdfPCell(new Phrase("UOB"));
							 students.addCell(table_cell);
						//	String e_mail=column_name.getString("User");
							table_cell=new PdfPCell(new Phrase("Year"));
							 students.addCell(table_cell);
						//	String year=column_name.getString("Select_priv");
							table_cell=new PdfPCell(new Phrase("E-Mail"));
							 students.addCell(table_cell);
							 table_cell=new PdfPCell(new Phrase("Contact"));
							 students.addCell(table_cell);
							break;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        try {
						query_set = stmt.executeQuery("SELECT * FROM student_list");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    
			        
			        try {
						while (query_set.next()) { 
										
						                String Name = query_set.getString("Name");
						                table_cell=new PdfPCell(new Phrase(Name));
						                students.addCell(table_cell);
						                String UOB=query_set.getString("UOB");
						                table_cell=new PdfPCell(new Phrase(UOB));
						                students.addCell(table_cell);
						                String Year=query_set.getString("Year");
						                table_cell=new PdfPCell(new Phrase(Year));
						                students.addCell(table_cell);
						                String E_Mail=query_set.getString("E_Mail");
						                table_cell=new PdfPCell(new Phrase(E_Mail));
						                students.addCell(table_cell);
						                String contact=query_set.getString("contact");
						                table_cell=new PdfPCell(new Phrase(contact));
						                students.addCell(table_cell);
						                }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        /* Attach report table to PDF */
			        try {
						student_list.add(students);
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}                       
			        student_list.close();
			        
			        /* Close all DB related objects */
			       
			      //  column_name.close();
			        try {
						query_set.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			        try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}        
			        JOptionPane.showMessageDialog(null, "download complete");
			}
		});
		
		lsnorthpanel.add(lsDownload);
		
		JButton lsUpdate = new JButton("UPDATE");
		lsUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new  update().setVisible(true);
				//lssouthpanel.setVisible(true);
			table.setEnabled(true);
			}
		});
		lsnorthpanel.add(lsUpdate);
		
		//JButton lssearchbutton = new JButton("Search");//-->experiment //
		JComboBox comboBox_lststndn = new JComboBox();//-->listof students name
		String [] cblistofstdnt=new String[] {"Search by","Name", "UOB", "Year"};//
	//	searching ttsf=	new searching();
		lstextfield = new JTextField();
	
		lsnorthpanel.add(lstextfield);
		lstextfield.setColumns(10);
		comboBox_lststndn.setModel(new DefaultComboBoxModel(cblistofstdnt));
		
		comboBox_lststndn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
					
					try {
					
						searching ttsf=	new searching();
						String columnname=comboBox_lststndn.getSelectedItem().toString();
				//		System.out.println(columnname);
						ttsf.search(table, lstextfield, Listofstudents,columnname);
						lstextfield.setText(null);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
					}});
	
		lsnorthpanel.add(comboBox_lststndn);
		
	
		lsnorthpanel.add(lstextfield);
	
		//-->adding combo box for list of students
		JComboBox comboBox = new JComboBox();
		String [] x=new String[] {"All", "Alphabetically", "Year"};
		comboBox.setModel(new DefaultComboBoxModel(x));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				int columnIndexToSort ;
				if(comboBox.getSelectedItem().toString().equals("Alphabetically")){
					columnIndexToSort = 0;
					TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
					sorter.setSortable(1, false);
					sorter.setSortable(2, false);
					sorter.setSortable(3, false);
					table.setRowSorter(sorter);
					List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				
					sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
				 
					sorter.setSortKeys(sortKeys);
					sorter.sort();
				}
				else if(comboBox.getSelectedItem().toString().equals("Year")){
					columnIndexToSort = 2;
					TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
					sorter.setSortable(1, false);
					sorter.setSortable(2, false);
					sorter.setSortable(3, false);
					table.setRowSorter(sorter);
					List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				
					sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
				 
					sorter.setSortKeys(sortKeys);
					sorter.sort();
				}
				else if(comboBox.getSelectedItem().toString().equals("All")){
					columnIndexToSort = 0;
					TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
					sorter.setSortable(1, false);
					sorter.setSortable(2, false);
					sorter.setSortable(3, false);
					table.setRowSorter(sorter);
					List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				
					sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.UNSORTED));
				 
					sorter.setSortKeys(sortKeys);
					sorter.sort();
				}
			//	TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<DefaultTableModel>(){
			//	table.setRowSorter(sorter);
			}
		});
		
		lsnorthpanel.add(comboBox);
		tableHeader.setResizingAllowed(false);
		
		conn1 = DriverManager.getConnection(connectionURL,"root","");
		stmt1 = conn1.createStatement();


		rs1 = stmt1.executeQuery("select * from teachers_Data");
	//	tableHeader1.setReorderingAllowed(false);
		//tableHeader1.setResizingAllowed(false);
		
		/*listofgroups = new JPanel();
		listofgroups.setBounds(0, 49, 694, 315);
		contentPane.add(listofgroups);
		
		*/
				
		/*lpnorthpanel = new JPanel();
		listofgroups.add(lpnorthpanel, BorderLayout.NORTH);
		
		
		lpnorthpanel.add(lpdownload);
		*/
		JButton lpsave1 = new JButton("Save");
		
		
		
		
	//	txtListofstudents = new JTextField();
	//	txtListofstudents.setText("listofstudents");
	//	txtListofstudents.setBounds(198, 64, 103, 20);
	//	Listofstudents.add(txtListofstudents);
	//	txtListofstudents.setColumns(10);
		listofpas = new JPanel();
		listofpas.setBounds(0, 49, 694, 315);
		contentPane.add(listofpas);
		table1 = new JTable();
		table1.setModel(DbUtils.resultSetToTableModel(rs1));
		JTableHeader tableHeader1 = table1.getTableHeader();
		listofpas.setLayout(new BorderLayout(0, 0));
		
				table1.setEnabled(false);
				
				
				JScrollPane tableContainer1 = new JScrollPane(table1);
				listofpas.add(tableContainer1, BorderLayout.CENTER);
				
				lpnorthpanel = new JPanel();
				listofpas.add(lpnorthpanel, BorderLayout.NORTH);
				lpnorthpanel.setVisible(false);
				
				JButton lpdownload = new JButton("DOWNLOAD");
				lpdownload.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//==>
						 Document teacher_list = new Document();
					        
								try {
									PdfWriter.getInstance(teacher_list, new FileOutputStream("teacher_list.pdf"));
								} catch (FileNotFoundException e7) {
									// TODO Auto-generated catch block
									e7.printStackTrace();
								} catch (DocumentException e7) {
									// TODO Auto-generated catch block
									e7.printStackTrace();
								}
							teacher_list.open(); 
					        PdfPTable teacher = new PdfPTable(3);
					        
					        PdfPCell table2_cell ;
					        ResultSet query_set=null;
					        
								try {
									query_set = stmt1.executeQuery("Show columns from teachers_Data");
								} catch (SQLException e6) {
									// TODO Auto-generated catch block
									e6.printStackTrace();
								}
										        
								try {
									while(query_set.next()){
									//	String name=column_name.getString("host");
										table2_cell=new PdfPCell(new Phrase("Name"));
										 teacher.addCell(table2_cell);
									//	String contact=column_name.getString("Db");
										table2_cell=new PdfPCell(new Phrase("Deparment"));
										 teacher.addCell(table2_cell);
									//	String e_mail=column_name.getString("User");
										table2_cell=new PdfPCell(new Phrase("Email_Id"));
										 teacher.addCell(table2_cell);
										break;
									}
								} catch (SQLException e5) {
									// TODO Auto-generated catch block
									e5.printStackTrace();
								}
							
					        
								try {
									query_set = stmt1.executeQuery("SELECT * FROM teachers_Data");
								} catch (SQLException e4) {
									// TODO Auto-generated catch block
									e4.printStackTrace();
								}
							
								try {
									while (query_set.next()) { 
													
									                
													
													String Name = query_set.getString("Name");
													
									                table2_cell=new PdfPCell(new Phrase(Name));
									                teacher.addCell(table2_cell);
									                 
												
													String Department = query_set.getString("Department");
										            table2_cell=new PdfPCell(new Phrase(Department));
									                teacher.addCell(table2_cell);
									                
													
													String 	Email_Id = query_set.getString("Email_Id");
													
									                table2_cell=new PdfPCell(new Phrase(Email_Id));
									                teacher.addCell(table2_cell);
									                }
								} catch (SQLException e4) {
									// TODO Auto-generated catch block
									e4.printStackTrace();
								}
							/* Attach report table to PDF */
					       
							try {
								teacher_list.add(teacher);
							} catch (DocumentException e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
							                       
					        teacher_list.close();
					        JOptionPane.showMessageDialog(null, "download complete");
					        /* Close all DB related objects */
					       
					      //  column_name.close();
					        try {
								query_set.close();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
					        try {
								stmt1.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								conn1.close();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}});
				
				
				
				lpnorthpanel.add(lpdownload);
				
				
				lpnorthpanel.add(lpdownload);
				
			//	JButton lpsearchbutton = new JButton("Search");
				
				//JButton lssearchbutton = new JButton("Search");//-->experiment //
				JComboBox comboBox_lstpat = new JComboBox();//-->listof students name
				String [] cblistofpat=new String[] {"Search by","Name", "Department"};//
			//	searching ttsf=	new searching();
				lptextfield = new JTextField();
			
			//	lsnorthpanel.add(lptextfield);
				lptextfield.setColumns(10);
				comboBox_lstpat.setModel(new DefaultComboBoxModel(cblistofpat));
				
				comboBox_lstpat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						
							
							try {
							
								searching ttsf=	new searching();
								String columnname=comboBox_lstpat.getSelectedItem().toString();
						//		System.out.println(columnname);
								ttsf.searchteachers(table1, lptextfield, listofpas,columnname);
								lptextfield.setText(null);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
							}});
			
				lpnorthpanel.add(comboBox_lstpat);
				
			
				lpnorthpanel.add(lptextfield);
				
			//	lpnorthpanel.add(lpsearchbutton);
				
				/*lptextfield = new JTextField();
				lpnorthpanel.add(lptextfield);
				lptextfield.setColumns(10);*/
				//combobox for list of pas
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Alphabetically", "Department wise"}));
				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int columnIndexToSort ;
						if(comboBox_1.getSelectedItem().toString().equals("Alphabetically")){
							columnIndexToSort = 0;
							TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
							sorter.setSortable(1, false);
							sorter.setSortable(2, false);
						//	sorter.setSortable(3, false);
							table1.setRowSorter(sorter);
							List<RowSorter.SortKey> sortKeys = new ArrayList<>();
						 
						
							sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
						 
							sorter.setSortKeys(sortKeys);
							sorter.sort();
						}
						else if(comboBox.getSelectedItem().toString().equals("Department wise")){
							columnIndexToSort = 2;
							TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
							sorter.setSortable(1, false);
							sorter.setSortable(2, false);
						//	sorter.setSortable(3, false);
							table1.setRowSorter(sorter);
							List<RowSorter.SortKey> sortKeys = new ArrayList<>();
						 
						
							sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
						 
							sorter.setSortKeys(sortKeys);
							sorter.sort();
						}
						else if(comboBox.getSelectedItem().toString().equals("All")){
							columnIndexToSort = 0;
							TableRowSorter<TableModel> sorter = new TableRowSorter<>(table1.getModel());
							sorter.setSortable(1, false);
							sorter.setSortable(2, false);
						//	sorter.setSortable(3, false);
							table1.setRowSorter(sorter);
							List<RowSorter.SortKey> sortKeys = new ArrayList<>();
						 
						
							sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.UNSORTED));
						 
							sorter.setSortKeys(sortKeys);
							sorter.sort();
						}
					//	TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<DefaultTableModel>(){
					//	table.setRowSorter(sorter);
					}
					
				});
				
				lpnorthpanel.add(comboBox_1);
				
											
							
							listofpas.setVisible(false);
	//	tableHeader1.setResizingAllowed(false);
		


//		txtListofpas = new JTextField();
//		txtListofpas.setText("listofpas");
//		txtListofpas.setBounds(296, 27, 86, 20);
//		listofpas.add(txtListofpas);
//		txtListofpas.setColumns(10);
							
		Connection conn0 = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
		Statement stmt0 = conn0.createStatement();


		ResultSet rs0 = stmt0.executeQuery("select * from groups");
		table0 = new JTable();
		table0.setModel(DbUtils.resultSetToTableModel(rs0));
		JTableHeader tableHeader0 = table0.getTableHeader();
		//listofgroups.setLayout(new BorderLayout(0, 0));

		listofgroups = new JPanel();
		listofgroups.setBounds(0, 51, 694, 313);
		contentPane.add(listofgroups);
		listofgroups.setLayout(new BorderLayout(0, 0));

		
		lgnorthpanel = new JPanel();
		listofgroups.add(lgnorthpanel, BorderLayout.NORTH);
		lgnorthpanel.setVisible(false);
		
		JButton lgdownload = new JButton("DOWNLOAD");
		lgdownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==>
				 Document groups = new Document();
			        
						try {
							PdfWriter.getInstance(groups, new FileOutputStream("groups.pdf"));
						} catch (FileNotFoundException e7) {
							// TODO Auto-generated catch block
							e7.printStackTrace();
						} catch (DocumentException e7) {
							// TODO Auto-generated catch block
							e7.printStackTrace();
						}
					groups.open(); 
			        PdfPTable group = new PdfPTable(3);
			        
			        PdfPCell group_cell ;
			        ResultSet query_set=null;
			        
						try {
							query_set = stmt1.executeQuery("Show columns from groups");
						} catch (SQLException e6) {
							// TODO Auto-generated catch block
							e6.printStackTrace();
						}
								        
						try {
							while(query_set.next()){
							//	String name=column_name.getString("host");
								group_cell=new PdfPCell(new Phrase("Group_no"));
								 group.addCell(group_cell);
							//	String contact=column_name.getString("Db");
								group_cell=new PdfPCell(new Phrase("Teacher_name"));
								 group.addCell(group_cell);
							//	String e_mail=column_name.getString("User");
								group_cell=new PdfPCell(new Phrase("Students_name"));
								 group.addCell(group_cell);
								break;
							}
						} catch (SQLException e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
					
			        
						try {
							query_set = stmt1.executeQuery("SELECT * FROM groups");
						} catch (SQLException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					
						try {
							while (query_set.next()) { 
											
							                
											
											String group_no = query_set.getString("Group_no");
											
							                group_cell=new PdfPCell(new Phrase(group_no));
							                group.addCell(group_cell);
							                 
										
											String Teacher_name = query_set.getString("Teacher_name");
								            group_cell=new PdfPCell(new Phrase(Teacher_name));
							                group.addCell(group_cell);
							                
											
											String 	Students_name = query_set.getString("Student_name");
											
							                group_cell=new PdfPCell(new Phrase(Students_name));
							                group.addCell(group_cell);
							                }
						} catch (SQLException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
					// Attach report table to PDF 
			       
					try {
						groups.add(group);
					} catch (DocumentException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					                       
			        groups.close();
			        JOptionPane.showMessageDialog(null, "download complete");
			        // Close all DB related objects 
			       
			      //  column_name.close();
			        try {
						query_set.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
			        try {
						stmt0.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						conn0.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}});
		
		table0.setEnabled(false);
		
		//tableHeader0.setReorderingAllowed(false);
		lgnorthpanel.add(lgdownload);
		
		JScrollPane tableContainer0 = new JScrollPane(table0);
		listofgroups.add(tableContainer0, BorderLayout.CENTER);
		conn0.close();

	//	JButton lgsearcbutton = new JButton("Search");
		//JButton lssearchbutton = new JButton("Search");//-->experiment //
				JComboBox comboBox_lstgroups = new JComboBox();//-->listof groups name
				String [] cblistofgroups=new String[] {"Search by","Group_no"};//
			//	searching ttsf=	new searching();
				lgtextfield = new JTextField();
			
				lgnorthpanel.add(lgtextfield);
		//		lstextfield.setColumns(10);
				comboBox_lstgroups.setModel(new DefaultComboBoxModel(cblistofgroups));
				
				comboBox_lstgroups.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						
							
							try {
							
								searching ttsf=	new searching();
								String columnname=comboBox_lstgroups.getSelectedItem().toString();
						//		System.out.println(columnname);
								ttsf.searchgroups(table0, lgtextfield, listofgroups,columnname);
								lgtextfield.setText(null);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
							}});
			
				lgnorthpanel.add(comboBox_lstgroups);
				
			
				lgnorthpanel.add(lgtextfield);
	//	lgnorthpanel.add(lgsearcbutton);
		
		lgtextfield = new JTextField();
		lgnorthpanel.add(lgtextfield);
		lgtextfield.setColumns(10);
	
	}
		

}