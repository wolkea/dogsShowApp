package pl.chatkakudlatka.dogsShowApp.model.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showAddNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.getAllUserList();
        model.addAttribute("listUsers", listUsers);
        return "user/users";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout, RedirectAttributes ra) {
        return "user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("editPassword")
    public String getAllUserList(Model model) {
        List<User> allList = userService.getAllUserList();
        model.addAttribute("wtList",allList);
        if (allList.size()==1) {
            return "user/changePassword";
        } return "user/changeAdminPassword";

    }


    @PostMapping("editPassword")
    public String savePassword(ServletWebRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String username = parameterMap.get("changeUsername")[0];
        String password = parameterMap.get("pwd1")[0];
        userService.changeUserPassword(username, password);
        return "/";
    }

}