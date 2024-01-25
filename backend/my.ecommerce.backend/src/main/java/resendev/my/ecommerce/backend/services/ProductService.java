package resendev.my.ecommerce.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import resendev.my.ecommerce.backend.entities.Product;
import resendev.my.ecommerce.backend.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
