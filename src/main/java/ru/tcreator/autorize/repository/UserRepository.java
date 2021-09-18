package ru.tcreator.autorize.repository;

import org.springframework.stereotype.Repository;
import ru.tcreator.autorize.model.Authorities;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {



    public List<Authorities> getUserAuthorities(String user, String password) {
        var list = new ArrayList<Authorities>();
        switch(user) {
            case "admin": {
                if(password.equals("1234")) {
                    list.add(Authorities.DELETE);
                    list.add(Authorities.WRITE);
                    list.add(Authorities.READ);
                }
                break;
            }
            case "user": {
                if(password.equals("4321")) {
                    list.add(Authorities.WRITE);
                    list.add(Authorities.READ);
                }
                break;
            }
        }
        return list;
    }
}