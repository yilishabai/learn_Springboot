package com.sevice;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public User get(String openid) { return userRepository.findUsersByOpenid(openid); }

    public void update(User user){
        userRepository.save(user);
    }

    public void remove(int id){
        userRepository.delete(id);
    }

    public List<User> findAll(){
        List<User> all = userRepository.findAll();
        return all;
    }

    @Transactional
    public void insertMany(List<User> users){
        for(int i = 0;i<users.size();i++){
            userRepository.save(users.get(i));
        }
    }

}
