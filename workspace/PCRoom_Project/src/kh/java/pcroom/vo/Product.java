package kh.java.pcroom.vo;

public class Product {
	String name;
	int price;
	String category;
	int productCount;
	
	public Product(){ }
	
	public Product(String name, int price, String category, int productCount) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.productCount = productCount;
	}
	public int getProductCount() {
		return productCount;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		new Member().setProductPrice(price);
		return price;
	}

	public String getCategory() {
		return category;
	}

	
}
