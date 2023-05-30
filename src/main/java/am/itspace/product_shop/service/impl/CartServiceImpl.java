package am.itspace.product_shop.service.impl;

import am.itspace.product_shop.entity.Cart;
import am.itspace.product_shop.entity.Product;
import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.repository.CartRepository;
import am.itspace.product_shop.repository.ProductRepository;
import am.itspace.product_shop.security.CurrentUser;
import am.itspace.product_shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Cart> allCart() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> findByUserId(User user) {
        return cartRepository.findAllByProducts_Id(user.getId());
    }

    @Override
    public void saveCart(Cart cart, int id, CurrentUser currentUser) {
        List<Product> allById = productRepository.findAllById(Collections.singleton(id));
        cart.setProducts(allById);
        cart.setUser(currentUser.getUser());
        cartRepository.save(cart);

    }

    @Override
    public void deleteCartById(int id) {
        cartRepository.deleteById(id);
    }

}
