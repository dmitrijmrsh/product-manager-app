package catalogue.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import catalogue.entity.Product;
import catalogue.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> findAllProducts(String filter) {
        if (filter != null && !filter.isEmpty()) {
            return this.productRepository.findAllByTitleLikeIgnoreCase("%" + filter + "%");
        }
        return this.productRepository.findAll();
    }

    @Override
    @Transactional
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(-1, title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    @Transactional
    public void updateProduct(Integer productId, String title, String details) {
        this.productRepository.findById(productId)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw new NoSuchElementException("catalogue.errors.product.not_found");
                });
    }

    @Override
    @Transactional
    public void deleteProduct(Integer productId) {
        this.productRepository.deleteById(productId);
    }
}
