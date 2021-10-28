package com.hairplace.repository;

import com.hairplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByName(String name);

    Optional<User> findByLogin(String login);
    
    Optional<UserModel> findByEmailAndPassword(String email,String password);

}