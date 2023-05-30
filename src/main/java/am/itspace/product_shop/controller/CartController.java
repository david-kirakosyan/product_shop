package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.Cart;
import am.itspace.product_shop.security.CurrentUser;
import am.itspace.product_shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/carts", method = RequestMethod.GET)
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String addCartPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("users", cartService.findByUserId(currentUser.getUser()));
        return "/carts";
    }


    @PostMapping("/add/{id}")
    public String addCart(@PathVariable("id") int id, @ModelAttribute Cart cart,
                          @AuthenticationPrincipal CurrentUser currentUser) {
        cartService.saveCart(cart, id, currentUser);
        return "redirect:/";
    }
}
