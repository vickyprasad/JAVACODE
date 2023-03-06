package Bike;

import java.sql.*;

import loginInfo.LoginAssignment1;

public class BikeDemo1 {
	static Connection con=null;
	static PreparedStatement pstmt=null;
	static ResultSet rs=null;
	static Statement stmt=null;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void addBike(String model,String company,double price) {
		
		String query="insert into bike_info (model,company,price) values(?,?,?)";
		String query1="select * from bike_info";
		try {
			
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setString(1,model);
			pstmt.setString(2,company);
			pstmt.setDouble(3,price);
			int count1=pstmt.executeUpdate();
			System.out.println(count1+" Record inserted" );
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getBikebymodel(String model) {
		String query="select * from bike_info ";
		boolean status=false;
		try {
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		System.out.println("MODEL\t\tCOMPANY\t\tPRICE");
		System.out.println("=============================");
		while(rs.next())
		{
			String dmodel=rs.getString(2);
			
			if(dmodel.equalsIgnoreCase(model)) {
				
				String model1=rs.getString(2);
				String company=rs.getString(3);
				double price=rs.getDouble(4);
				System.out.println(model1+"\t\t"+company+"\t\t"+price);
				
				status=true;	
				}
			}
		
		
			if(status==false)
			{
				System.out.println("Details Not Found");
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public void getBikebycompany(String company) {
		String query="select * from bike_info ";
		boolean status=false;
		try {
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		System.out.println("MODEL\t\tCOMPANY\t\tPRICE");
		System.out.println("=============================");
		while(rs.next())
		{
			String dcompany=rs.getString(3);
			
			if(dcompany.equalsIgnoreCase(company)) {
				
				String model1=rs.getString(2);
				String company1=rs.getString(3);
				double price=rs.getDouble(4);
				System.out.println(model1+"\t\t"+company1+"\t\t"+price);
				
				status=true;	
				}
			}
		
		
			if(status==false)
			{
				System.out.println("Details Not Found");
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void getAll() {
		String query="select * from bike_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			System.out.println("ID\tMODEL\t\tCOMPANY\t\tPRICE");
			System.out.println("=============================");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String model=rs.getString(2);
				String company=rs.getString(3);
				double price=rs.getDouble(4);
				System.out.println(id+"\t"+model+"\t\t"+company+"\t\t"+price);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
