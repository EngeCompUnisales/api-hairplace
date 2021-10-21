package com.hairplace.controller;

import com.hairplace.model.UserModel;
import com.hairplace.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(tags = "Endpoints de User", value = "")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login/{login}")
    public Optional<UserModel> loginByLogin(@PathVariable(value = "login") String login) {
        System.out.println("BATEU");
        return userRepository.findByLogin(login);
    }

    @PostMapping("/user")
    public UserModel saveUser(@RequestBody @Valid UserModel user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{name}")
    public void deleteUser(@PathVariable(value = "name") String name) {
        Optional<UserModel> user = userRepository.findByName(name);
        userRepository.deleteById(user.get().getId());
    }

}
