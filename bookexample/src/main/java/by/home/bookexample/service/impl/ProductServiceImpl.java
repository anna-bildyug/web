package by.home.bookexample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.home.bookexample.domain.Product;
import by.home.bookexample.domain.repository.ProductRepository;
import by.home.bookexample.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.getProductsByManufacturer(manufacturer);
	}

	@Override
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		Map<String, Integer> priceParams = new HashMap<>();
		for(String key: filterParams.keySet())
		{
			priceParams.put(key, Integer.valueOf(filterParams.get(key).get(0)));
		}
		return productRepository.getProductsByPriceFilter(priceParams);
	}

	@Override
	public void addProduct(Product product) {
		 productRepository.addProduct(product);		
	}

}
