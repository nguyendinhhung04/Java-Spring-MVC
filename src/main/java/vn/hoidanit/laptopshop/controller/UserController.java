package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "client/CreateNewUser";
    }

    @RequestMapping(value = "/admin/user/save", method = RequestMethod.POST)
    public String saveUser(Model model, @ModelAttribute("newUser") User hoidanit) {

        userService.handleSaveUser(hoidanit);

        // model.addAttribute("email", hoidanit.getEmail());
        // model.addAttribute("password", hoidanit.getPassword());
        // model.addAttribute("fullname", hoidanit.getFullname());
        // model.addAttribute("address", hoidanit.getAddress());
        // model.addAttribute("phone", hoidanit.getPhone());
        return "redirect:/admin/user/view";
    }

    @RequestMapping("/admin/user/view")
    public String getUserViewPage(Model model) {
        List<User> arrUsers = this.userService.getAllUser();
        model.addAttribute("users", arrUsers);
        return "admin/UserView";
    }

    @RequestMapping("/admin/user/view/{id}")
    public String getUserViewDetailPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/UserViewDetail";
    }

    @RequestMapping("/admin/user/modify/{id}")
    public String getUserModifyPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/UserModify";
    }
}
