package com.example.taskappbackend.api;

import com.example.taskappbackend.dto.UserDTO;
import com.example.taskappbackend.service.custom.UserService;
import com.example.taskappbackend.util.ValidationGroups;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@Validated(ValidationGroups.Create.class) @RequestBody UserDTO user) {
        userService.createNewUserAccount(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/me", consumes = "application/json")
    public void updateUserAccountDetails(
            @Validated(ValidationGroups.Update.class) @RequestBody UserDTO user,
            @AuthenticationPrincipal(expression = "username") String username) {
        user.setUsername(username);
        userService.updateUserAccountDetails(user);
    }

    @GetMapping(value = "/me", produces = "application/json")
    public UserDTO getUserAccountDetails(@AuthenticationPrincipal(expression = "username") String username) {
        return userService.getUserAccountDetails(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/me")
    public void deleteUserAccount(@AuthenticationPrincipal(expression = "username") String username) {
        userService.deleteUserAccount(username);
    }
}
