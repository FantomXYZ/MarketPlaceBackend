package by.fantom.product_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id")
    private Long owner_id;

    @Column(name = "description")
    private String description;

    @Column(name = "image_id")
    private Long image_id;
}
