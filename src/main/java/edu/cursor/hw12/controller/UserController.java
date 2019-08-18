package edu.cursor.hw12.controller;

import edu.cursor.hw12.entities.HttpResponse;
import edu.cursor.hw12.entities.User;
import edu.cursor.hw12.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{email}")
    public User getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping
    public HttpResponse addUser(@RequestBody User user) throws IOException {
        userService.addUser(user);
        return new HttpResponse("Ok", "Data is saved", false);
    }
}
