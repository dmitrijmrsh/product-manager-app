package manager.repository;

import manager.entity.ProductManagerUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductManagerUserRepository extends CrudRepository<ProductManagerUser, Integer> {
    Optional<ProductManagerUser> findByUsername(String username);
}
