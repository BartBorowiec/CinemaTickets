package uph.ii.borowiec.cinematickets.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uph.ii.borowiec.cinematickets.dto.UserDto;
import uph.ii.borowiec.cinematickets.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    UserService userService;

    @GetMapping({"/",""})
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping({"/",""})
    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        //userService.registerNewUserAccount(userDto);

        return "redirect:/login";
    }
}
