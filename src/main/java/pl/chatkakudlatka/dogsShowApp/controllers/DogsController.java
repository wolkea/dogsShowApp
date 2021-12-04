package pl.chatkakudlatka.dogsShowApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.chatkakudlatka.dogsShowApp.model.Dog;
import pl.chatkakudlatka.dogsShowApp.model.Kennel;
import pl.chatkakudlatka.dogsShowApp.services.DogServices;

import java.util.Date;

@Controller
@RequestMapping("/dog")
public class DogsController {
    private final DogServices dogServices;

    @Autowired
    public DogsController(DogServices dogServices) {
        this.dogServices = dogServices;
    }

    @GetMapping("/testAdd")
    public String showAddNewUser(Model model, String name, String callName) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setCallName(callName);
        dog.setBirthDay(new Date());
        dogServices.save(dog);

        return "/";
    }


}