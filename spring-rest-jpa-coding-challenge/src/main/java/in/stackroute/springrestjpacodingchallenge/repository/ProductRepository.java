package in.stackroute.springrestjpacodingchallenge.repository;

import in.stackroute.springrestjpacodingchallenge.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
