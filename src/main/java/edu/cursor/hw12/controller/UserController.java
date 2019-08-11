package edu.cursor.hw12.controller;

import edu.cursor.hw12.entities.User;
import edu.cursor.hw12.handler.UserExceptionHandler;
import edu.cursor.hw12.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserExceptionHandler userExceptionHandler;

    @GetMapping("{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
