package am.itspace.product_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String title;
    private double price;
    private String description;
    private String imgPath;

    @ManyToOne
    private Category category;
}
