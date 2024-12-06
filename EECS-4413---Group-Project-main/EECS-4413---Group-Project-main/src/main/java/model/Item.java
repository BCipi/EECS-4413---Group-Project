package model;

public class Item {
	private String name;
	private int id;
	private String description;
	private String category_Name;
	private String brand;
	private int price;
	private int stock;
	
	public Item(String n, int i, String d, String c, String b, int p, int s) {
		this.name = n;
		this.id = i;
		this.description = d;
		this.category_Name = c;
		this.brand = b;
		this.price = p;
		this.stock = s;
	}
	
	public Item(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getCategoryName() {
		return this.category_Name;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescription(String des) {
		this.description = des;
	}
	
	public void setCategoryName(String cat) {
		this.category_Name = cat;
	}
	
	public void setBrand(String br) {
		this.brand = br;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
}
