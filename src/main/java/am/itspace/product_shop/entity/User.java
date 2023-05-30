package am.itspace.product_shop.entity;

import am.itspace.product_shop.entity.type.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
