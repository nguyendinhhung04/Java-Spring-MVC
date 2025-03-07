package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("eric", test);
        List<User> arrUsers = this.userService.getAllUsersByEmail("hung@gmail.com");
        System.out.println(arrUsers);
        return "hello";
    }

    @RequestMapping("/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "CreateNewUser";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {

        userService.handleSaveUser(hoidanit);

        model.addAttribute("email", hoidanit.getEmail());
        model.addAttribute("password", hoidanit.getPassword());
        model.addAttribute("fullname", hoidanit.getFullname());
        model.addAttribute("address", hoidanit.getAddress());
        model.addAttribute("phone", hoidanit.getPhone());
        return "UserAdded";
    }
}
