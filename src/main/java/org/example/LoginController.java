package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*") // allow all origins for testing
public class LoginController {

    private final Map<String, String> userCredentials = Map.of("Cleveland", "1234", "Caimin", "123");

    @GetMapping("/login")
    public String authenticate(
            @RequestParam(name="username") String username,
            @RequestParam(name="password") String password
    ) {
        if(userCredentials.containsKey(username)) {
            if (userCredentials.get(username).equals(password)) {
                return "OK";
            }
            return "Wrong Password";

        }
           return "Wrong Username";

    }
}
