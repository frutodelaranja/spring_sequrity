package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String adminPage(Model model){
        List<User> users = userService.listUsers();
        List<String> checkbox = new ArrayList<>();
        model.addAttribute("users", users);
        model.addAttribute("userRole", checkbox);
        model.addAttribute("newUser", (new User()));
        return "admin";

    }



}
