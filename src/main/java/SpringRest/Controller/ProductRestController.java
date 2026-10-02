package SpringRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringRest.Entity.Product;
import SpringRest.Service.ProductService;
import SpringRest.dto.ProductDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@Valid @RequestBody ProductDto productDto)
	{
		String msg = productService.saveProduct(productDto);
		
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id)
	{
		Product product = productService.getProductById(id);
		
//		product=null;
		
		if(product == null)
		{
			return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> allProducts = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/byname")
	public ResponseEntity<Product> getByName(@RequestParam String name)
	{
		Product product = productService.findByName(name);
		
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id)
	{
		String msg = productService.deleteById(id);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Product product)
	{
		String msg = productService.updateById(id, product);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
	
	//Not Recommended
	
//	@GetMapping("/products/{id}")
//	public Product getProductById(@PathVariable Integer id)
//	{
//		Product product = productService.getProductById(id);
//		
//		return product;
//	}
//	
//	@GetMapping("/products")
//	public List<Product> getAllProducts()
//	{
//		List<Product> allProducts = productService.getAllProducts();
//		
//		return allProducts;
//		
//	}

}
