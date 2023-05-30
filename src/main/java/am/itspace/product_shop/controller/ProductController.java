package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.Category;
import am.itspace.product_shop.entity.Product;
import am.itspace.product_shop.service.CategoryService;
import am.itspace.product_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/add")
    public String addProductPage(ModelMap modelMap) {
        List<Category> categories = categoryService.allCategory();
        modelMap.addAttribute("categories", categories);
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        productService.saveProduct(product, multipartFile);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String removeProduct(@RequestParam("id") int id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
