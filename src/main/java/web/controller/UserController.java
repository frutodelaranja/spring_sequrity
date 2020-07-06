package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String userPage(Model model, Authentication authentication){

        User user = userService.findByLogin(authentication.getName());
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }




    @PostMapping("/admin/save")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/admin/delete")
    public String deleteUser(@RequestParam(value = "id") Long id, Model model){
        model.addAttribute("id",id);
        userService.delete(id);
        return "redirect:/admin";
    }

}