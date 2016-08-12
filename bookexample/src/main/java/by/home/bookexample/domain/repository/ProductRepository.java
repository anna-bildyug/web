package by.home.bookexample.domain.repository;

import java.util.List;

import by.home.bookexample.domain.Product;

public interface ProductRepository {

	List<Product> getAllProducts();
	
	Product getProductById(String productId);
}
