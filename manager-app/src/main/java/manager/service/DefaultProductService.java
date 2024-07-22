package manager.service;

import lombok.RequiredArgsConstructor;
import manager.entity.Product;
import manager.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(-1, title, details));
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productRepository.find(productId);
    }

    @Override
    public void updateProduct(Integer productId, String title, String details) {
        this.productRepository.find(productId)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw new NoSuchElementException("catalogue.errors.product.not_found");
                });
    }

    @Override
    public void deleteProduct(Integer productId) {
        this.productRepository.delete(productId);
    }
}
