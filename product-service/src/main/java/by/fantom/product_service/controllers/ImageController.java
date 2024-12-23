package by.fantom.product_service.controllers;


import by.fantom.product_service.dto.ImageDTO;
import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
