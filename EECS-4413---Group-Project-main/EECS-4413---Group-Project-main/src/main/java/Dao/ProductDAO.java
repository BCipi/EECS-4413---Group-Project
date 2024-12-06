package Dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
    List<Product> getProductsByCategory(int categoryId);
    List<Product> getProductsByBrand(int brandId);
    Product getProduct(int productId);
	List<Product> searchProductsByName(String searchQuery);
}
