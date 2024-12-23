package by.fantom.product_service.entities;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Entity
@Getter
@Setter
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    private Long id;

    @Column(name="imagePath")
    private String imagePath;
}
