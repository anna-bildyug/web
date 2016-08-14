package by.home.bookexample.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.home.bookexample.domain.Product;
import by.home.bookexample.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping()
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());

		return "products";
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("/{category}/{price}")
	public String filterProducts(@MatrixVariable(pathVar = "price") Map<String, List<String>> filterParams,
			@PathVariable("category") String productCategory, @RequestParam("manufacturer") String manufacturer,
			Model model) {
		Set<Product> productsByPriceFilter = productService.getProductsByPriceFilter(filterParams);
		List<Product> productsByCategory = productService.getProductsByCategory(productCategory);
		List<Product> productsByManufacturer = productService.getProductsByManufacturer(manufacturer);
		productsByPriceFilter.retainAll(productsByManufacturer);
		productsByPriceFilter.retainAll(productsByCategory);
		model.addAttribute("products", productsByPriceFilter);
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

}
