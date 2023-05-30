package am.itspace.product_shop.controller;


import am.itspace.product_shop.entity.Category;
import am.itspace.product_shop.repository.CategoryRepository;
import am.itspace.product_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String categoriesPage(ModelMap modelMap) {
        List<Category> categories = categoryService.allCategory();
        modelMap.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/add")
    public String addCategoryPage() {
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete")
    public String removeCategory(@RequestParam("id") int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
