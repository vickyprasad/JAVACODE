package Domain;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.ProductDAO;
import Dto.Product;

public class ProductMainApp {

		static Scanner sc= new Scanner(System.in);
		
	public static void main(String[] args) {
		System.out.println("Select Mode of Operation");
		System.out.println("1: Add Product");
		System.out.println("2: Delete Product");
		System.out.println("3: Display Products");
		
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			insertProduct();
		}
		else if(choice==2) {
			removeProduct();
		}
		else if(choice==3) {
			showProduct();
		}
		else {
			System.out.println("Invalid Choice");
		}
		
	}

		public static void insertProduct() {
			System.out.println("Enter Product Name");
			String name=sc.next();
			System.out.println("Enter Product Price");
			double price=sc.nextDouble();
			
			//Add data to DTO Object
			Product p1=new Product();
			p1.setProductName(name);
			p1.setProductPrice(price);
			
			//Pass DTO object as argument to addProduct() method
			ProductDAO d1=new ProductDAO();
			int count=d1.addProduct(p1);
			System.out.println(count+" Product Inserted Successfully");
			
		}
		
		public static void removeProduct() {
			System.out.println("Enter Product Id to Delete Product");
			int id=sc.nextInt();
			
			Product p2=new Product();
			p2.setProductId(id);
			
			ProductDAO d2=new ProductDAO();
			d2.deleteProduct(p2);
			
			System.out.println(" Product Removed Successfully");
			}
			
		
		
		public static void showProduct() {
			ProductDAO p1=new ProductDAO();
			ArrayList<Product> data=p1.displayproduct();
			System.out.println("ID\tNAME\t\tPRICE");
			for(Product p:data) {
				System.out.println(p);
			}

		}
		
}
