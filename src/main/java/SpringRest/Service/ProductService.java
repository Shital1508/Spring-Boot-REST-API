package SpringRest.Service;

import java.util.List;

import SpringRest.Entity.Product;
import SpringRest.dto.ProductDto;

public interface ProductService {
	
	Product getProductById(Integer id);
	
	List<Product> getAllProducts();
	
	String saveProduct(ProductDto productDto);
	
	Product findByName(String name);

	String deleteById(Integer id);
	
	String updateById(Integer id,Product product);
}
