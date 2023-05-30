package am.itspace.product_shop.repository;


import am.itspace.product_shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByProducts_Id(int id);

    void deleteByUser_id(int id);

}
