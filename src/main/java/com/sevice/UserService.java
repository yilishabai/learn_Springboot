package com.sevice;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        User save = userRepository.save(user);
        return save;
    }

    public User get(int id){
        return userRepository.getOne(id);
    }

    public void remove(int id){
        userRepository.delete(id);
    }

    public List<User> findAll(){
        List<User> all = userRepository.findAll();
        return all;
    }


    public List<User> findUsersByAge(int age){
        return userRepository.findUsersByAgeEquals(age);
    }
}
