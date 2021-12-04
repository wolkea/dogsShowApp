package pl.chatkakudlatka.dogsShowApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.chatkakudlatka.dogsShowApp.auth.User;
import pl.chatkakudlatka.dogsShowApp.auth.UserServiceImpl;
import pl.chatkakudlatka.dogsShowApp.model.Dog;
import pl.chatkakudlatka.dogsShowApp.model.FCIGroup;

@Controller
@RequestMapping("/test")
public class TestController {

    private final UserServiceImpl userService;

    public TestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/fcigroup")
    public String showAddNewUser(Model model, Integer number) {
        Dog dog = new Dog();
        dog.setName("Triss");
        FCIGroup fciGroup = FCIGroup.FCI_1;
        model.addAttribute("group", fciGroup);
        model.addAttribute("dog", dog);
        return "test/fcigroup";
    }

    @GetMapping("/register")
    public String showAddNewUser(Model model) {
        User user = new User();
        user.setEmail("a@ab.pl");
        model.addAttribute("user", user);
        return "user/add";
    }


}