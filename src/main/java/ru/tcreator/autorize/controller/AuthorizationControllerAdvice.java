package ru.tcreator.autorize.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.tcreator.autorize.exceptions.InvalidCredentials;
import ru.tcreator.autorize.exceptions.UnauthorizedUser;

@RestControllerAdvice
public class AuthorizationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String badCred(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String notAuthorised(UnauthorizedUser e) {
        return e.getMessage();
    }
}
