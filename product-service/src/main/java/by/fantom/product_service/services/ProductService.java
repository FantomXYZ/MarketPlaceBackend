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
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getSellerId(),
                product.getDescription(),
                product.getPrice(),
                product.getImageId()
        );
    }

    public Product toEntity(ProductDTO productDTO){
        return new Product(productDTO.getId(),productDTO.getName(),
                productDTO.getSellerId(),productDTO.getDescription(),productDTO.getPrice(),productDTO.getImageId());
    }


    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return toDTO(product.get());
    }

    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ProductDTO create(ProductDTO productDTO){
        Product product = productRepository.save(toEntity(productDTO));
        return toDTO(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public ProductDTO update(Long id, ProductDTO productDTO){
        productDTO.setId(id);
        Product updatedProduct = productRepository.save(toEntity(productDTO));
        return toDTO(updatedProduct);
    }
}
