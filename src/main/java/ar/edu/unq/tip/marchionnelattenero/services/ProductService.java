package ar.edu.unq.tip.marchionnelattenero.services;

import ar.edu.unq.tip.marchionnelattenero.factories.ProductFactory;
import ar.edu.unq.tip.marchionnelattenero.models.Product;
import ar.edu.unq.tip.marchionnelattenero.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productService")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductFactory productFactory;

    @Transactional
    public Product createProduct(String name, String description) {
        Product product = new Product(name, description);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Transactional
    public Product getProduct(String name) {
        return this.productFactory.getProductByName(name);
    }

    @Transactional
    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
