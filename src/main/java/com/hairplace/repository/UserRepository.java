package com.hairplace.repository;

import com.hairplace.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

    Optional<UserModel> findByName(String name);

    Optional<UserModel> findByLogin(String login);

}