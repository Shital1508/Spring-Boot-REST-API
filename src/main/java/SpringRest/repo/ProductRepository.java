package SpringRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringRest.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);

}
