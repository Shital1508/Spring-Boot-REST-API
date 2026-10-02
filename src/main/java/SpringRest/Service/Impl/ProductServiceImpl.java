package SpringRest.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringRest.Entity.Product;
import SpringRest.Exception.ProductNotFoundException;
import SpringRest.Service.ProductService;
import SpringRest.dto.ProductDto;
import SpringRest.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	
	@Override
	public Product getProductById(Integer id) {
		
		Optional<Product> byId = productRepository.findById(id);
		
		if(byId.isPresent())
		{
			Product product = byId.get();
			return product;
		}
		
		throw new ProductNotFoundException("Product Not Found with id:"+id);
	}


	@Override
	public List<Product> getAllProducts() {
		
		List<Product> allProducts = productRepository.findAll();
		
		return allProducts;
	}


	@Override
	public String saveProduct(ProductDto productDto) {
		
		Product entity=new Product();
		entity.setName(productDto.getName());
		entity.setPrice(productDto.getPrice());
		entity.setQty(productDto.getQty());
		entity.setCategory(productDto.getCategory());
		entity.setMfgDate(productDto.getMfgDate());
		entity.setExpDate(productDto.getExpDate());
		
		productRepository.save(entity);
		
		return "Product saved Successfully";
	}


	@Override
	public Product findByName(String name) {
		
		Product product = productRepository.findByName(name);
		
		if(product != null)
		{
			return product;
		}
		
		throw new ProductNotFoundException("Product Not Found with name:"+name);
	}


	@Override
	public String deleteById(Integer id) {
		
		if(productRepository.existsById(id))
		{
			productRepository.deleteById(id);
			return "product deleted successfully";
		}
		
		throw new ProductNotFoundException("Product Not Found with id:"+id);
	}


	@Override
	public String updateById(Integer id, Product product) {
		
		Optional<Product> byId = productRepository.findById(id);
		
		if(byId.isPresent())
		{
			Product existingProduct = byId.get();
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQty(product.getQty());
			existingProduct.setCategory(product.getCategory());
			existingProduct.setMfgDate(product.getMfgDate());
			existingProduct.setExpDate(product.getExpDate());
			
			productRepository.save(existingProduct);
			
			return "product updated successfully";
		}
		
		throw new ProductNotFoundException("Product Not Found with id:"+id);
	}

}
