package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Sale implements Serializable{
	private String custName;
	private String itemName;
	private ArrayList<Integer> itemId;
	private ArrayList<Integer> quantity;
	private int transactionId;
	
	public Sale(String cname, ArrayList<Integer> id, String iname, ArrayList<Integer> qty, int tId) {
		this.custName = cname;
		this.itemId = id;
		this.quantity = qty;
		this.transactionId = tId;
		this.itemName = iname;
	}
	
	public String getCustName() {
		return this.custName;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public ArrayList<Integer> getItemId() {
		return this.itemId;
	}
	
	public ArrayList<Integer> getQuantity() {
		return this.quantity;
	}
	
	public int getTransactionId() {
		return this.transactionId;
	}
}
