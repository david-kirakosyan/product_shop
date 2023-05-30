package am.itspace.product_shop.service.impl;

import am.itspace.product_shop.entity.Order;
import am.itspace.product_shop.entity.Product;
import am.itspace.product_shop.repository.CartRepository;
import am.itspace.product_shop.repository.OrderRepository;
import am.itspace.product_shop.repository.ProductRepository;
import am.itspace.product_shop.security.CurrentUser;
import am.itspace.product_shop.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;


    @Override
    @Transactional
    public void saveOrder(Order order, CurrentUser currentUser, List<Integer> product) {
        order.setDatetime(new Date());
        order.setUser(currentUser.getUser());

        List<Product> products = new ArrayList<>();
        for (Integer productId : product) {
            Optional<Product> byId = productRepository.findById(productId);
            if (byId.isPresent()) {
                Product product1 = byId.get();
                if (!products.contains(product1)) {
                    products.add(product1);
                }
            }
        }

        order.setProducts(products);
        orderRepository.save(order);

        int id = currentUser.getUser().getId();
        cartRepository.deleteByUser_id(id);
    }

}
