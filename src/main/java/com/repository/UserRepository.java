package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//orm
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findUsersByAgeEquals(int age);
    public List<User> findUsersByAgeEqualsAndNameEquals(int age ,String name);
}
