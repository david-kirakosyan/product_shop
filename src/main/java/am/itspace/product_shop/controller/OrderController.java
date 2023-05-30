package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.Order;
import am.itspace.product_shop.security.CurrentUser;
import am.itspace.product_shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order,
                           @AuthenticationPrincipal CurrentUser currentUser,
                           @RequestParam("id") List<Integer> id) {
        orderService.saveOrder(order, currentUser, id);
        return "redirect:/orders";
    }
}
