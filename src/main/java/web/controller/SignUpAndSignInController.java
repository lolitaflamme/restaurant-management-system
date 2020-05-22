package web.controller;

import dao.entity.PassportData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import service.api.UserDtoService;
import service.model.UserDto;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpAndSignInController {

    private final UserDtoService userDtoService;

    @ModelAttribute(value = "userDto")
    public UserDto addUserToModel() {
        return new UserDto();
    }

    @GetMapping({"/welcome", "/"})
    public String getWelcomePage() {
        return "welcome";
    }

    @ModelAttribute()
    @GetMapping("/signUp")
    public String getSignUpForm() {
        return "sign-up";
    }

    @PostMapping("/signUp")
    public String createUser(@Valid UserDto userDto) {
        userDtoService.createUser(userDto);
        return "sign-up";
    }

    @GetMapping("/signIn")
    public String getSignInForm() {
        return "sign-in";
    }

    @GetMapping("/user/home")
    public String getUserHome(/*@AuthenticationPrincipal org.springframework.security.core.userdetails.User user*/) {
        return "user-home";
    }

    @ModelAttribute()
    @GetMapping("/user/additionalInformation")
    public String getAdditionalInformationForm() {
        return "user-additional-information";
    }

    @PostMapping("/user/additionalInformation")
    public String updateUser(@Valid UserDto userDto) {
        userDtoService.updateUser(userDto);
        return "user-additional-information";
    }

    @GetMapping("/admin/home")
    public String getAdminPage() {
        return "admin-home";
    }
}
