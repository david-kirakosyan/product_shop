package am.itspace.product_shop.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@UtilityClass
public class ImageUtil {


    public static String uploadImage(MultipartFile multipartFile, String path) throws IOException {
        String fileName = null;
        if (multipartFile != null && !multipartFile.isEmpty()) {
            fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(path + fileName);
            multipartFile.transferTo(file);
            return fileName;
        }
        return null;
    }
}
