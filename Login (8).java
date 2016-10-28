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
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField t;
	private JPasswordField passwordField;
	static Login l;
	private JTextField textField_1;
	JPanel email;
	JPanel signin;
	JPanel code;
	JPanel menuebar;
	JPanel home;
	JPanel Listofstudents;
	JPanel listofpas;
	JPanel listofgroups;
	private JTextField txtHoempanel;
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
	JPanel lssouthpanel;
	JPanel lpsouthpanel ;
	JPanel lgsouthpanel ;
	JPanel lsnorthpanel;
	JPanel lpnorthpanel;
	JPanel lgnorthpanel;
	JTableHeader tableHeader;
	/**
	 * Launch the application.
	 */
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {


		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));

		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

				vector.add(rs.getObject(columnIndex));
				System.out.println(vector);

			}
			data.add(vector);

		}



		return new DefaultTableModel(data, columnNames);

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
		ImageIcon img=new ImageIcon("G:/year 2/pdf/resources/download.jpg");
	    setIconImage(img.getImage());
		setTitle("login");
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
		code = new JPanel();
		code.setBounds(0, 0, 694, 364);
		code.setVisible(false);
		code.setLayout(null);


		JLabel lblCodeHasBeen = new JLabel("A code has been sent to your email id.Please enter code you received.");
		lblCodeHasBeen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodeHasBeen.setBounds(42, 6, 477, 17);
		code.add(lblCodeHasBeen);

		JLabel lblCode = new JLabel("Code:");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCode.setBounds(100, 65, 37, 17);
		code.add(lblCode);

		contentPane.add(code);	
		textField = new JTextField();
		textField.setBounds(174, 65, 86, 20);
		code.add(textField);
		textField.setColumns(10);

		JLabel lblPassword_1 = new JLabel("New Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword_1.setBounds(44, 112, 93, 17);
		code.add(lblPassword_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 112, 86, 20);
		code.add(passwordField);

		JLabel lblConfirmpassword = new JLabel("ConfirmPassword:");
		lblConfirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmpassword.setBounds(26, 167, 111, 17);
		code.add(lblConfirmpassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(174, 167, 86, 20);
		code.add(passwordField);
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.setBounds(174, 248, 111, 23);
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				signin.setVisible(true);

				email.setVisible(false);	
				code.setVisible(false);

			}
		});
		code.add(btnOk_1);
		String y=(textField.getText());

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
				code.setVisible(true);
				signin.setVisible(false);
				email.setVisible(false);
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
		JToggleButton tglbtnHome = new JToggleButton("HOME");
		tglbtnHome.setSelected(true);
		tglbtnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.setVisible(true);
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
				//Isnorthpanel.setVisible(true);
			}
		});
		menuebar.add(tglbtnListOfStudents);

		JToggleButton tglbtnListOfPas = new JToggleButton("List of PAs");
		tglbtnListOfPas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofpas.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);

				//	Listofstudents.setVisible(true);
				//home.setVisible(false);

			}
		});
		menuebar.add(tglbtnListOfPas);

		JToggleButton tglbtnListOfGroups = new JToggleButton("List of Groups and PAS");
		tglbtnListOfGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listofgroups.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);
				listofpas.setVisible(false);
			}
		});
		menuebar.add(tglbtnListOfGroups);

		JToggleButton tglbtnLogout = new JToggleButton("LOG OUT");
		tglbtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin.setVisible(true);
				home.setVisible(false);
				Listofstudents.setVisible(false);
				listofpas.setVisible(false);
				listofgroups.setVisible(false);
				menuebar.setVisible(false);
				lblNewLabel.setVisible(false);
			}
		});
		menuebar.add(tglbtnLogout);
		toggle_group.add(tglbtnHome);
		toggle_group.add(tglbtnListOfGroups);
		toggle_group.add(tglbtnListOfPas);
		toggle_group.add(tglbtnListOfStudents);
		toggle_group.add(tglbtnLogout);


		home = new JPanel();
		home.setBounds(0, 51, 694, 313);
		contentPane.add(home);
		home.setLayout(null);

		txtHoempanel = new JTextField();
		txtHoempanel.setText("Hoempanel");
		txtHoempanel.setBounds(228, 5, 162, 20);
		home.add(txtHoempanel);
		txtHoempanel.setColumns(10);

		Listofstudents = new JPanel();
		Listofstudents.setBounds(0, 51, 694, 313);
		contentPane.add(Listofstudents);
		
		
		conn = DriverManager.getConnection(connectionURL,"root","");
		stmt = conn.createStatement();


		rs = stmt.executeQuery("select * from student_list");
		table = new JTable(buildTableModel(rs));
		tableHeader = table.getTableHeader();
		Listofstudents.setLayout(new BorderLayout(0, 0));

		table.setEnabled(false);
		tableHeader.setReorderingAllowed(false);
		
		JScrollPane tableContainer = new JScrollPane(table);
		Listofstudents.add(tableContainer);
		
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
			lssouthpanel.setVisible(true);
			table.setEnabled(true);
			}
		});
		lsnorthpanel.add(lsUpdate);
		
		lssouthpanel = new JPanel();
		lssouthpanel.setVisible(false);
		Listofstudents.add(lssouthpanel, BorderLayout.SOUTH);
		
		JButton lssave = new JButton("Save");
		lssave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lssouthpanel.setVisible(false);
			table.setEnabled(false);
			}
		});
		lssouthpanel.add(lssave);
		
		JButton lscancel = new JButton("Cancel");

		lssouthpanel.add(lscancel);
		lscancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lssouthpanel.setVisible(false);
			table.setEnabled(false);
			}
		});
		tableHeader.setResizingAllowed(false);
		
		
		
		
	//	txtListofstudents = new JTextField();
	//	txtListofstudents.setText("listofstudents");
	//	txtListofstudents.setBounds(198, 64, 103, 20);
	//	Listofstudents.add(txtListofstudents);
	//	txtListofstudents.setColumns(10);
		listofpas = new JPanel();
		listofpas.setBounds(0, 49, 694, 315);
		contentPane.add(listofpas);
		
		conn1 = DriverManager.getConnection(connectionURL,"root","");
		stmt1 = conn1.createStatement();


		rs1 = stmt1.executeQuery("select * from teachers_Data");
		table1 = new JTable(buildTableModel(rs1));
		JTableHeader tableHeader1 = table1.getTableHeader();
		listofpas.setLayout(new BorderLayout(0, 0));

		table1.setEnabled(false);
		tableHeader1.setReorderingAllowed(false);
		
		
		JScrollPane tableContainer1 = new JScrollPane(table1);
		listofpas.add(tableContainer1, BorderLayout.CENTER);
		
		lpnorthpanel = new JPanel();
		listofpas.add(lpnorthpanel, BorderLayout.NORTH);
		
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
		
		JButton lpupdate = new JButton("UPDATE");
		lpupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lpsouthpanel.setVisible(true);
			table1.setEnabled(true);
			}
		});
		lpnorthpanel.add(lpupdate);
		
		lpsouthpanel = new JPanel();
	
		listofpas.add(lpsouthpanel, BorderLayout.SOUTH);
	lpsouthpanel.setVisible(false);	
		JButton lpsave = new JButton("Save");
		lpsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lpsouthpanel.setVisible(false);
			table1.setEnabled(false);
			}
		});
		lpsouthpanel.add(lpsave);
		
		JButton lpcancel = new JButton("Cancel");
		lpsouthpanel.add(lpcancel);
		lpcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lpsouthpanel.setVisible(false);
			table1.setEnabled(false);
			}
		});
		tableHeader1.setResizingAllowed(false);
		
		
		listofpas.setVisible(false);	


//		txtListofpas = new JTextField();
//		txtListofpas.setText("listofpas");
//		txtListofpas.setBounds(296, 27, 86, 20);
//		listofpas.add(txtListofpas);
//		txtListofpas.setColumns(10);

		listofgroups = new JPanel();
		listofgroups.setBounds(0, 51, 694, 313);
		contentPane.add(listofgroups);
		listofgroups.setLayout(new BorderLayout(0, 0));

		txtListofgroupsandpas = new JTextField();
		txtListofgroupsandpas.setText("Listofgroupsandpas");
		listofgroups.add(txtListofgroupsandpas);
		txtListofgroupsandpas.setColumns(10);
		
		lgnorthpanel = new JPanel();
		listofgroups.add(lgnorthpanel, BorderLayout.NORTH);
		
		JButton lgDownload = new JButton("DOWNLOAD");
		lgnorthpanel.add(lgDownload);
		
		JButton lgUpdate = new JButton("UPDATE");
		lgUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lgsouthpanel.setVisible(true);
			}
		});
		lgnorthpanel.add(lgUpdate);
		
		lgsouthpanel = new JPanel();
		lgsouthpanel.setVisible(false);
		listofgroups.add(lgsouthpanel, BorderLayout.SOUTH);
		
		JButton lgsave = new JButton("Save");
		lgsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lgsouthpanel.setVisible(false);
			
			}
		});
		lgsouthpanel.add(lgsave);
		
		JButton lgcancel = new JButton("Cancel");
		lgcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lgsouthpanel.setVisible(false);
			
			}
		});
		lgsouthpanel.add(lgcancel);
		home.setVisible(false);
	}
}