package by.fantom.product_service.services;

import by.fantom.product_service.dto.ImageDTO;
import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.entities.Image;
import by.fantom.product_service.entities.Product;
import by.fantom.product_service.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    private ImageDTO toDTO(Image image){
        return new ImageDTO(image.getId(),image.getImagePath());
    }

    public ImageDTO findById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        return toDTO(image.get());
    }
}
