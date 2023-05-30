package am.itspace.product_shop.service;



import am.itspace.product_shop.entity.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void userSave(User user);

    void deleteUserById(int id);
}
