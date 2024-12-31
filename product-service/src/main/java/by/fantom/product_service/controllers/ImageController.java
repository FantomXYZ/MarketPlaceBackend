package by.fantom.product_service.controllers;


import by.fantom.product_service.dto.ImageDTO;
import by.fantom.product_service.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getImage(@PathVariable Long id){
        ImageDTO image = imageService.findById(id);
        return ResponseEntity.ok(image);
    }

    @GetMapping
    public ResponseEntity<List<ImageDTO>> getAllImages(){
        List<ImageDTO> images = imageService.findAll();
        return ResponseEntity.ok(images);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public ResponseEntity<ImageDTO> create(@RequestBody ImageDTO image){
        ImageDTO createsImage = imageService.create(image);
        return ResponseEntity.status(HttpStatus.CREATED).body(createsImage);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public ResponseEntity<ImageDTO> update(@PathVariable Long id,@RequestBody ImageDTO image){
        ImageDTO updatedImage = imageService.update(id,image);
        return ResponseEntity.ok(updatedImage);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','SELLER')")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        imageService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
