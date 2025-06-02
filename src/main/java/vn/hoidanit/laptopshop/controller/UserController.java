package vn.hoidanit.laptopshop.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;

//MVC
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // test connect database
    // get user with condition to test connect database
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

    // Return table.jsp with list user
    @RequestMapping("/admin/user")
    public String getTablePage(Model model) {
        List<User> listUser = this.userService.getAllUser();
        model.addAttribute("listUser", listUser);
        return "admin/user/table";
    }

    // Return user-detail.jsp with user's Id
    @RequestMapping("/admin/user/{id}")
    public String getDetailUserPage(Model model, @PathVariable int id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/user-detail";
    }

    // Return create.jsp
    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // Return update.jsp
    // Render information of user chosen by user's id
    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable int id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("currentUser", currentUser);
        return "admin/user/update";
    }

    // Update information of user
    // if information of user modified, it will be updated with new information
    @PostMapping("/admin/user/update")
    public String updateUserById(@ModelAttribute("currentUser") User userUpdate) {
        // userUpdate.getId() return long
        User user = this.userService.getUserById(userUpdate.getId());
        if (user != null) {
            user.setFullName(userUpdate.getFullName());
            user.setPhone(userUpdate.getPhone());
            user.setAddress(userUpdate.getAddress());

            // save data user to database
            this.userService.handSaveUser(user);
        }
        return "redirect:/admin/user";
    }

    // Return delete.jsp with user's id
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        model.addAttribute("currentUser", new User());
        return "admin/user/delete";
    }

    // Delete user by id
    @PostMapping("/admin/user/delete")
    public String deleteUserById(@ModelAttribute("currentUser") User userDetele) {
        System.out.println("Id=" + userDetele.getId());
        this.userService.deleteUserById((int) userDetele.getId());
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String creatUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
        userService.handSaveUser(hoidanit);
        System.out.println("run here" + hoidanit);
        return "redirect:/admin/user";// redirect when not keep data
        // return "forward:/admin/user";// forward when using model.Attribute() and keep
        // data

    }

}
