package edu.cursor.hw12.repository;

import edu.cursor.hw12.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public User getUser(User user) {
        users.add(user);
        return user;
    }
}
