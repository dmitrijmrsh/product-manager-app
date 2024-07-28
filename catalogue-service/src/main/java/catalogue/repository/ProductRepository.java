package catalogue.repository;

import catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);

    Optional<Product> find(Integer productId);

    void delete(Integer productId);
}
