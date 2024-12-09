package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	ArrayList<Item> cart;
	
	public Cart() {
		cart = new ArrayList<Item>();
	}
	
	public void addItem(String name, int id, String description, String category, String brand, int price, int stock) {
		// Check if item id is found and increase quantity by 1]
		
		boolean itemFound = false;
//		for(Item item: cart) {
//			if(item.getId() == id) {
//				int oldQty = item.getQuantity();
//				item.setOrderedQty(oldQty + 1);
//				itemFound = true;
//				break;
//			}
//		}
		
		if(!itemFound) {
			Item item = new Item(name, id, description, category, brand, price, stock);
			cart.add(item);
		}
	}
	
	public void removeItem(int id) {
		for(Item item: cart) {
			if(item.getId() == id) {
				cart.remove(item);
				break;
			}
		}
	}
	
	public void update(int id, int newQty) {
		//TODO
		
	}
	
	public List<Item> getItems() {
		return cart;
	}
	
	public void printCart() {
		for(Item item: cart) {
			System.out.print(item.getName() + ", ");

		}
	}
	public void testCart() {
		System.out.println("Cart test");
	}

}
