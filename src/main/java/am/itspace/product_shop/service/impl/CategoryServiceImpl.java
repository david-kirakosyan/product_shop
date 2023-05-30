package am.itspace.product_shop.service.impl;

import am.itspace.product_shop.entity.Cart;
import am.itspace.product_shop.entity.Category;
import am.itspace.product_shop.repository.CartRepository;
import am.itspace.product_shop.repository.CategoryRepository;
import am.itspace.product_shop.service.CartService;
import am.itspace.product_shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

}
