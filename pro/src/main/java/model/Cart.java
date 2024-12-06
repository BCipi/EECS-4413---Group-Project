package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, Integer> items = new HashMap<>();

    public void addProduct(int productId) {
        items.put(productId, items.getOrDefault(productId, 0) + 1);
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }
}
