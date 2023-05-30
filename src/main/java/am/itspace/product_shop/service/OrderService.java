package am.itspace.product_shop.service;

import am.itspace.product_shop.entity.Order;
import am.itspace.product_shop.security.CurrentUser;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order, CurrentUser currentUser, List<Integer> productIds);

}
