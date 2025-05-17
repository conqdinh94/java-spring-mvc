package vn.hoidanit.laptopshop.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;

//MVC
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        Scanner sc = new Scanner(System.in);
        List<User> listUser = userService.getAllUser();
        System.out.println("List User:");
        for (User user : listUser) {
            System.out.println(user);
        }

        System.out.println();
        List<User> listUserByEmail = userService.getAllUserByEmail("helio@example.com");
        System.out.println("List User get by email:");
        for (User user : listUserByEmail) {
            System.out.println(user);
        }

        System.out.println();
        List<User> listUserByEmailAndAddress = userService.getAllUserByEmailAndAddress("abc@gmail.com", "Quang Ninh");
        System.out.println("List user get by email and address:");
        for (User user : listUserByEmailAndAddress) {
            System.out.println(user);
        }

        model.addAttribute("test", "eric");
        model.addAttribute("message", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getTablePage(Model model) {
        List<User> listUser = this.userService.getAllUser();
        model.addAttribute("listUser", listUser);
        return "admin/user/table";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String creatUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        userService.handSaveUser(hoidanit);
        System.out.println("run here" + hoidanit);
        return "redirect:/admin/user";// redirect when not keep data
        // return "forward:/admin/user";// forward when using model.Attribute() and keep data 

    }

}
