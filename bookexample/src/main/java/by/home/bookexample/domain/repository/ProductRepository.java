package by.home.bookexample.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import by.home.bookexample.domain.Product;

public interface ProductRepository {

	List<Product> getAllProducts();
	
	Product getProductById(String productId);
	
	List<Product> getProductsByCategory(String category);
	
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	Set<Product> getProductsByPriceFilter(Map<String, Integer> filterParams);
	
	List <Product> getProductsByManufacturer(String manufacturer);
	
	void addProduct(Product product);
}
