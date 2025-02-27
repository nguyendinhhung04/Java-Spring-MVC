package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello from service";
    }

    public void handleSaveUser(User user)
    {
        userRepository.save(user);
    }

}


