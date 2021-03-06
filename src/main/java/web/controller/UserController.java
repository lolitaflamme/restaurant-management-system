package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.api.UserService;
import service.model.UserDto;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ModelAttribute(value = "userDto")
    public UserDto addUserToModel() {
        return new UserDto();
    }

    @GetMapping({"/welcome", "/"})
    public String getWelcomePage() {
        return "welcome";
    }

    @ModelAttribute()
    @GetMapping("/sign-up")
    public String getSignUpForm() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String createUser(@Valid UserDto userDto, BindingResult result) {
        userService.createUser(userDto);
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            return "redirect:sign-in";
        } else {
            return fieldErrors.toString();
        }
    }

    @GetMapping("/sign-in")
    public String getSignInForm() {
        return "sign-in";
    }

    @GetMapping("/user-home")
    public String getUserHome(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        return "user-home";
    }

    @ModelAttribute()
    @GetMapping("/user-additional-information")
    public String getAdditionalInformationForm() {
        return "user-additional-information";
    }

    @PostMapping("/user-additional-information")
    public String updateUser(@Valid UserDto userDto, BindingResult result) {
        userService.updateUser(userDto);
        List<FieldError> fieldErrors = result.getFieldErrors();
        if (fieldErrors.isEmpty()) {
            return "redirect:user-home";
        } else {
            return fieldErrors.toString();
        }
    }

    @GetMapping("/admin-home")
    public String getAdminPage() {
        return "admin-home";
    }
}
