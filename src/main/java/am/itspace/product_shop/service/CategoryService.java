package am.itspace.product_shop.service;

import am.itspace.product_shop.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> allCategory();

    void saveCategory(Category category);

    void deleteCategoryById(int id);
}
