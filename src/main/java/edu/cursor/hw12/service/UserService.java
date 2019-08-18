package edu.cursor.hw12.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cursor.hw12.entities.HttpResponse;
import edu.cursor.hw12.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserService {

    public User getUser(String email) {
        User user = new User();
        user.setName("Michael");
        user.setSurName("Yevtushenko");
        user.setLastLoginDate(LocalDate.now());
        user.setAccessId("123321");
        user.setEmail(email);
        user.setHomeworkToIsDone(new HashMap<>());
        return user;
    }

    public HttpResponse addUser(User user) throws IOException {
        user.setAccessId(Double.toString(Math.random() * 50 + 1));

        ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileOutputStream("target/user.json"), user);
    return new HttpResponse("Ok", "Data is saved", false);}
}