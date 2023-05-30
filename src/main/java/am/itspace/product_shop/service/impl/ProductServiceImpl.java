package am.itspace.product_shop.service.impl;

import am.itspace.product_shop.entity.Product;
import am.itspace.product_shop.repository.ProductRepository;
import am.itspace.product_shop.service.ProductService;
import am.itspace.product_shop.util.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Value("${product_shop.upload.image.path}")
    private String productImageUploadPath;

    @Override
    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        String image = ImageUtil.uploadImage(multipartFile, productImageUploadPath);
        product.setImgPath(image);
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

}
