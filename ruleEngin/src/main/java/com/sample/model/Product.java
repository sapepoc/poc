package com.sample.model;

public class Product 
{
	private double price;
	private String name;
	private ProductType productType;

	public Product(String name, double price, ProductType productType) 
	{
		this.name = name;
		this.price = price;
		this.productType = productType;
	}

	public ProductType getProductType() {
		return productType;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public double getPrice() 
	{
		return price;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", name=" + name + ", productType=" + productType + "]";
	}
}
