package com.hairplace.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hairplace.model.User;
import com.hairplace.repository.UserRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de Usuarios", value = "")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login/{login}")
    public Optional<User> loginByLogin(@PathVariable(value = "login") String login) {
        return userRepository.findByLogin(login);
        
    @GetMapping("/auth/login")
    public Optional<UserModel> loginByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{name}")
    public void deleteUser(@PathVariable(value = "name") String name) {
        Optional<User> user = userRepository.findByName(name);
        userRepository.deleteById(user.get().getId());
    }

}
