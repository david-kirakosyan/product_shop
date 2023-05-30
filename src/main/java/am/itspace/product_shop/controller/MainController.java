package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.Product;
import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.entity.type.Role;
import am.itspace.product_shop.security.CurrentUser;
import am.itspace.product_shop.service.MainService;
import am.itspace.product_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final ProductService productService;


    @GetMapping("/")
    public String main(ModelMap modelMap) {
        List<Product> products = productService.allProduct();
        modelMap.addAttribute("products", products);
        return "index";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("profilePic") String profilePic) {
        return mainService.getImage(profilePic);
    }

    @GetMapping("/customLogin")
    public String customLoginPage() {
        return "customLoginPage";
    }

    @GetMapping("/customSuccessLogin")
    public String customSuccessLogin(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            if (user.getRole() == Role.ADMIN) {
                return "redirect:/";
            } else if (user.getRole() == Role.USER) {
                return "redirect:/";

            }
        }
        return "redirect:/";
    }
}
