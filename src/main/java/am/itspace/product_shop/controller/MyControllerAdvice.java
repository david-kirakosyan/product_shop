package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute("currentUser")
    public User currentUser(@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser != null){
            return currentUser.getUser();
        }
        return null;
    }
}
