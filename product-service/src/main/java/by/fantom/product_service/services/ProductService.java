package by.fantom.product_service.services;

import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.entities.Product;
import by.fantom.product_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDTO toDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getOwner_id(), product.getDescription(), product.getImage_id());
    }

    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return toDTO(product.get());
    }

    public Set<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::toDTO).collect(Collectors.toSet());

    }
}
