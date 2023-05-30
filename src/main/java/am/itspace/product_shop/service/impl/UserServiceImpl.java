package am.itspace.product_shop.service.impl;


import am.itspace.product_shop.entity.User;
import am.itspace.product_shop.entity.type.Role;
import am.itspace.product_shop.repository.UserRepository;
import am.itspace.product_shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }


    @Override
    public void userSave(User user) {
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (byEmail.isEmpty()){
            String password = user.getPassword();
            String encodePassword = passwordEncoder.encode(password);
            user.setRole(Role.USER);
            user.setPassword(encodePassword);
            userRepository.save(user);
        }

    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
