package by.home.bookexample.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import by.home.bookexample.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);

	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);

	List <Product> getProductsByManufacturer(String manufacturer);
	
	void addProduct(Product product);
}
