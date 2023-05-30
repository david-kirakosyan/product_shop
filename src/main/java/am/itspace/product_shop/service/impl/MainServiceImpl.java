package am.itspace.product_shop.service.impl;



import am.itspace.product_shop.service.MainService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class MainServiceImpl implements MainService {

    @Value("${product_shop.upload.image.path}")
    public String doctorImageUploadPath;


    @Override
    public byte[] getImage(String profilePic) {
        try {
            File file = new File(doctorImageUploadPath + profilePic);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                return IOUtils.toByteArray(fis);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
