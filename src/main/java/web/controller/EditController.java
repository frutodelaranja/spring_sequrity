package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/admin/edit")
public class EditController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String editPage(@RequestParam(value = "id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("editUser", user);
        return "edit";
    }

    @PostMapping
    public String editUser(@ModelAttribute("editUser") User user){
        userService.edit(user);
        return "redirect:/admin";
    }

}
