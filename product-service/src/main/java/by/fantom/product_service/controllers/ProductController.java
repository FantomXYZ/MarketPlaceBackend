package by.fantom.product_service.controllers;


import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getUser(@PathVariable Long id){
        ProductDTO product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<ProductDTO>> getAllUsers(){
        Set<ProductDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

}
