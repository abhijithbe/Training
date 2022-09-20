package com.example.basicapp;

import com.example.basicapp.UserDao.Users;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class DaoServiceUser {
    private static List<Users> users=new ArrayList<>();
    static {
        users.add(new Users(1,"abhi",90900909));
        users.add(new Users(2,"adarsh",420420420));
    }

    public List<Users> getAll() {
        return users;
    }
    public String addUser(Users user){
     users.add(user);
     return "success";
    }
    public Users fetchOne(int ids){
            Predicate<? super Users> predicate= user -> user.getId()==ids;
            return users.stream().filter(predicate).findFirst().orElse(null);


    }

    public void DeleteOne(int id) {
        Predicate<? super Users> predicate= user -> user.getId()==id;
        users.removeIf(predicate);
    }
}
