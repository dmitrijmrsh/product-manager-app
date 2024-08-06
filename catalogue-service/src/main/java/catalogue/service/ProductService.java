package catalogue.service;

import catalogue.entity.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Integer productId, String title, String details);

    void deleteProduct(Integer productId);
}
