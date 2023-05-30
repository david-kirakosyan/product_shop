package am.itspace.product_shop.service;

import am.itspace.product_shop.entity.Cart;
import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.security.CurrentUser;

import java.util.List;

public interface CartService {
    List<Cart> allCart();

    void saveCart(Cart cart, int id, CurrentUser currentUser);

    List<Cart> findByUserId(User user);

    void deleteCartById(int id);
}
