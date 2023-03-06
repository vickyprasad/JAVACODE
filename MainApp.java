package Bike;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		BikeDemo1 b1=new BikeDemo1();
		Scanner sc=new Scanner(System.in);
		
		
		String model,company;
		double price;
		boolean status=true;
		while(status) {
			System.out.println("Enter your choice");
			System.out.println("\n 1.Add Bike Information\n 2.Get Bike by Model\n 3.Get Bike by Company\n 4.Get All Bikes\n 5.Exit");
			int choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter model ");
				model=sc.next();
				System.out.println("Enter company");
				company=sc.next();
				System.out.println("Enter Price");
				price=sc.nextDouble();
				b1.addBike(model, company, price);
												
				break;
				
			case 2:
				System.out.println("Enter Model");
				model=sc.next();
				b1.getBikebymodel(model);
				break;
			case 3:
				System.out.println("Enter Company Name ");
				company=sc.next();
				b1.getBikebycompany(company);
				break;
			case 4:
				b1.getAll();
				break;
			case 5:
				status=false;
				break;
				
			}
			
		}
	}

}
