package Dto;

public class Product {
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	private int productId;
	private String productName;
	private double productPrice;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		
		return productId+"\t"+productName+"\t\t"+productPrice;
	}
}
