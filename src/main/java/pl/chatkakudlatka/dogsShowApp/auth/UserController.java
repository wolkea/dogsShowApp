package pl.chatkakudlatka.dogsShowApp.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.chatkakudlatka.dogsShowApp.model.Kennel;
import pl.chatkakudlatka.dogsShowApp.model.Language;
import pl.chatkakudlatka.dogsShowApp.model.Owner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        model.addAttribute("languageList", Language.values());
        model.addAttribute("kennelNamePositionList", Kennel.NamePossition.values());
        return "user/add";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
        Map<String, String[]> parameterMap = request.getParameterMap();


        boolean havedog = parameterMap.containsKey("havedog");
        if (havedog){
            String lastName = parameterMap.get("lastName")[0];
            String firstName = parameterMap.get("firstName")[0];
            Language language = Language.valueOf(parameterMap.get("language")[0]);

            Owner owner = new Owner();
            owner.setLastName(lastName);
            owner.setFirstName(firstName);
            owner.setLanguage(language);
            user.setOwner(owner);

            boolean havekennel = parameterMap.containsKey("havekennel");
            if (havekennel){
                String kennelName = parameterMap.get("kennelName")[0];
                Kennel.NamePossition kennelNamePossition = Kennel.NamePossition.valueOf(parameterMap.get("kennelNamePosition")[0]);

                Kennel kennel = new Kennel();
                kennel.setKennelName(kennelName);
                kennel.setKennelNamePossition(kennelNamePossition);
                owner.setKennel(kennel);
            }

        }
        User savedUser = userService.save(user);

        return "user/add";
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
        if (allList.size() == 1) {
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