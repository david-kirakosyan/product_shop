package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService USER_SERVICE;

    @GetMapping("/register")
    public String addUserPage() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
        USER_SERVICE.userSave(user);
        return "redirect:/";
    }
}
