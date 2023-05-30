package am.itspace.product_shop.service;

import am.itspace.product_shop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> allProduct();

    void saveProduct(Product product, MultipartFile multipartFile) throws IOException;

    void deleteProductById(int id);
}
