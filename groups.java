package raat2;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.proteanit.sql.DbUtils;


public class groups {
	public groups() throws BiffException, IOException, SQLException{
		File f=new File("G:\\year-3\\SEGP\\project\\20%\\teachers_Data.xls");
	    Workbook w= Workbook.getWorkbook(f);
	   Sheet s=w.getSheet(0);
	   File f1=new File("G:\\year-3\\SEGP\\project\\20%\\Book1.xls");
	    Workbook w1= Workbook.getWorkbook(f1);
	   Sheet s1=w1.getSheet(0);
	    
	    	
	    
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost/project","root","");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();
	
	
	String st = "";
	String st1 = "";
	int  total_students= s1.getRows()-1;
	int total_teachers = s.getRows()-1;
	int g=total_students/total_teachers+1;
	int z=0;
	String q = "";
	String values="";
	
	for(int i=0;i<total_teachers;i++){
		if (i==0){
			q="SELECT Name from teachers_data limit "+Integer.toString(i)+", "+Integer.toString(i+1);
		}
		else
			q="SELECT Name from teachers_data limit "+Integer.toString(i)+", "+Integer.toString(i);
		ResultSet rs =stmt.executeQuery(q);
		if (rs.next()){
			st = rs.getString("Name");
		}
		
		for(int j=0;j<g;j++){
			
			if (z==total_students){
				break;
			}
			values ="VALUES(";
			if (z==0){
				q="SELECT Name from student_list limit "+Integer.toString(z)+", "+Integer.toString(z+1);
			}
			else
				q = "SELECT Name from student_list limit "+Integer.toString(z)+", "+Integer.toString(z);
				
			ResultSet rs1 =stmt.executeQuery(q);
			if (rs1.next()){
				st1 = rs1.getString("Name");
			}
			if (j==0){
				values = values+Integer.toString(i+1)+",'"+st+"','"+st1+"')";
			}
			else
				values = values+Integer.toString(i+1)+",'-','"+st1+"')";
			z++;
			System.out.print(values);
			System.out.println();
			String sql = "INSERT INTO groups " +
			      values;
			stmt.executeUpdate(sql);
					
		}
		
		
		//values = values + st + ")";
		
		

	}
	  
	/*while(rs.next())  
	System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3));  */  
	}catch(Exception e){ System.out.println(e);} 
	
	}	
	
	public static void main(String args[]) throws BiffException, IOException, SQLException{
	    new groups();

}
}
