package edu.cursor.hw12.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cursor.hw12.entities.User;
import edu.cursor.hw12.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String email) {
        User user = new User();
        user.setName("Michael");
        user.setSurName("Yevtushenko");
        user.setLastLoginDate(LocalDate.now());
        user.setAccessId("123321");
        user.setEmail(email);
        user.setHomeworkToIsDone(new HashMap<>());
        return userRepository.getUser(user);
    }

    public User addUser(User user) {
        user.setAccessId(Double.toString(Math.random() * 50 + 1));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileOutputStream("target/user.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userRepository.getUser(user);
    }
}
