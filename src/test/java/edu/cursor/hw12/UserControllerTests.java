package edu.cursor.hw12;

import edu.cursor.hw12.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Test
    public void getUserTest() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/blabla@gmail.com";
        ResponseEntity<User> userResponse = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, userResponse.getStatusCode());
        assertEquals("blabla@gmail.com", userResponse.getBody().getEmail());
    }

    @Test
    public void addUserTest() {
        User user = new User();
        user.setName("Michael");
        user.setSurName("Yevtushenko");
        user.setLastLoginDate(LocalDate.now());
        user.setEmail("blabla@gmail.com");
        user.setHomeworkToIsDone(new HashMap<>());
        user.getHomeworkToIsDone().put("MyHomeWork", true);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user";

        HttpEntity<User> requestHttp = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, requestHttp, User.class);

        user.setAccessId(Double.toString(Math.random() * 50 + 1));

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user.getName(), responseEntity.getBody().getName());
        assertEquals(user.getSurName(), responseEntity.getBody().getSurName());
        assertEquals(user.getEmail(), responseEntity.getBody().getEmail());
    }
}
