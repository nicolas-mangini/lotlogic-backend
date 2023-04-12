package app.controller;

import app.model.response.TokenResponse;
import app.model.form.UserLoginForm;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(final UserService userService) {
        this.userService = userService;
    }

    //TODO fix String response to JSON format
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginForm user) {
        String token = this.userService.loginUser(user);
        return new ResponseEntity<>(new TokenResponse(token), HttpStatus.OK);
    }
}