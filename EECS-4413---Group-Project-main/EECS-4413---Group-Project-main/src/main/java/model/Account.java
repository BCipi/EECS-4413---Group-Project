package model;

public class Account {
	private String shipAddress;
	private String username;
	private String password;
	private String creditCard;
	private String name;
	private int priv;
	private String billingAddress;
	
	/*
	 * For Priv:
	 * 1 = basic user
	 * 2 = Admin user
	 * 0 = means nothing was entered. Default values for errors
	 */
	
	public Account(String address, String u, String p, String creditcard, String name, int priv, String bill) {
		this.shipAddress = address;
		this.username = u;
		this.password = p;
		this.creditCard = creditcard;
		this.name= name;
		this.priv = priv;
		this.billingAddress = bill;
	}
	
	//No set methods for priv and username because these shouldn't change throughout the lifetime of the object for security
	public String getShipAddress() {
		return this.shipAddress;
	}
	
	public void setShipAddress(String newShippingAddress) {
		this.shipAddress = newShippingAddress;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getCreditCard() {
		return this.creditCard;
	}
	
	public void setCreditCard(String newCC) {
		this.creditCard = newCC;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public int getPriv() {
		return this.priv;
	}
	
	public String getBillingAddress() {
		return this.billingAddress;
	}
	
	public void setBillingAddress(String bill) {
		this.billingAddress = bill;
	}
}
