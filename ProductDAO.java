package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dto.Product;

public class ProductDAO {
	static Connection con=null;
	static PreparedStatement pstmt=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7","root","sql123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int addProduct(Product p) {
		String query="insert into product_info (product_name,product_price) values(?,?)";
		int count=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,p.getProductName());
			pstmt.setDouble(2,p.getProductPrice());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void deleteProduct(Product p) {
		String query="delete from product_info where product_id=(?)";
	
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,p.getProductId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Product> displayproduct() {
		String query="select * from product_info";
		ArrayList<Product > products=new ArrayList<Product>();
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				double price=rs.getDouble(3);
				
				//add values to object
				Product p1=new Product();
				p1.setProductId(id);
				p1.setProductName(name);
				p1.setProductPrice(price);
				
				//add object to arrayList
				products.add(p1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	
}
