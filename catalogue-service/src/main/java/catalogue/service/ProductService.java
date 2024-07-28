package catalogue.service;

import catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    Product createProduct(String title, String details);

    Optional<Product> findById(Integer productId);

    void updateProduct(Integer productId, String title, String details);

    void deleteProduct(Integer productId);
}
