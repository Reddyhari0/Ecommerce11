package ecom.dao;
import java.sql.*;
public class DAO 
{
	Connection con;
	public DAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver is loaded");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","madhu","madhu123");
			System.out.println("Connected..");
		}catch(ClassNotFoundException ex)
		{
			System.out.println("Not loaded................");
			System.out.println(ex);
		}
		catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
	}
	
	public boolean doRegister(String phone,String password,String email,String gender,String city,String role)
	{
		boolean flag=false;
		try {
				PreparedStatement pstmt= con.prepareStatement("insert into register values(?,?,?,?,?,?)");
				pstmt.setString(1,phone);
				pstmt.setString(2,password);
				pstmt.setString(3,email);
				pstmt.setString(4,gender);
				pstmt.setString(5,city);
				pstmt.setString(6,role);
				int r=pstmt.executeUpdate();
				if(r>0)
				{
					flag=true;
				}
		}catch(SQLException ex)
		{
			System.out.println("Not Connected................");
			System.err.println(ex);
		}
		return flag;
	}
	

	public String loginCheck(String phone,String pwd)
	{
				String role=null;
				try {
				PreparedStatement pstmt=con.prepareStatement("select role from register where phone=? and password=?");
				pstmt.setString(1,phone);
				pstmt.setString(2,pwd);
				ResultSet rs= pstmt.executeQuery();
				if(rs.next())
				{
					role=rs.getString("role");
				}
				
				}catch(SQLException ex)
				{	System.err.println("Error while checking userid/pwd");
					System.out.println(ex);
				}
				return role;
	}
	
	
	public static void main(String args[])
	{
		new DAO();
	}
}



/*
 
 create table register
 (
 phone varchar2(10)primary key,
 password varchar2(15),
 email varchar2(25),
 gender varchar2(6),
 address varchar2(30)
 );
 
 * */
