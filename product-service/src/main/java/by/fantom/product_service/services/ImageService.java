package by.fantom.product_service.services;

import by.fantom.product_service.dto.ImageDTO;
import by.fantom.product_service.dto.ProductDTO;
import by.fantom.product_service.entities.Image;
import by.fantom.product_service.entities.Product;
import by.fantom.product_service.repositories.ImageRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    private ImageDTO toDTO(Image image){
        return new ImageDTO(image.getId(),image.getUrl());
    }

    private Image toEntity(ImageDTO imageDTO){
        return new Image(imageDTO.getId(),imageDTO.getUrl());
    }

    public ImageDTO findById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        return toDTO(image.get());
    }

    public List<ImageDTO> findAll() {
        List<ImageDTO> images = imageRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
        return images;
    }

    public ImageDTO create(ImageDTO image) {
        Image createdImage = imageRepository.save(toEntity(image));
        return toDTO(createdImage);
    }

    public ImageDTO update(Long id, ImageDTO image) {
        image.setId(id);
        Image updatedImage = imageRepository.save(toEntity(image));
        return toDTO(updatedImage);
    }

    public void delete(Long id) {
        imageRepository.deleteById(id);
    }
}
