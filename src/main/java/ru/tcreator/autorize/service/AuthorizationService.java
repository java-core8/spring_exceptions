package ru.tcreator.autorize.service;

import org.springframework.stereotype.Service;
import ru.tcreator.autorize.exceptions.InvalidCredentials;
import ru.tcreator.autorize.exceptions.UnauthorizedUser;
import ru.tcreator.autorize.model.Authorities;
import ru.tcreator.autorize.repository.UserRepository;

import java.util.List;


@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            System.out.println(1);
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
