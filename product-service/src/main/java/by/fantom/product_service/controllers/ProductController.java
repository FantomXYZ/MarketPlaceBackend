package by.fantom.product_service.controllers;


import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.services.ProductService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO,Authentication auth){
        String sellerId = auth.getName();
        productDTO.setSellerId(sellerId);
        ProductDTO createdProduct = productService.create(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public  ResponseEntity<ProductDTO> updateProductById(@RequestBody ProductDTO productDTO, @PathVariable Long id,Authentication auth){
        String sellerId = auth.getName();
        productDTO.setSellerId(sellerId);

        ProductDTO updatedProductDTO = productService.update(id,productDTO);
        return ResponseEntity.ok(updatedProductDTO);

    }

}
