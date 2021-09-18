package ru.tcreator.autorize.controller;

import org.springframework.web.bind.annotation.*;
import ru.tcreator.autorize.model.Authorities;
import ru.tcreator.autorize.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }


}
