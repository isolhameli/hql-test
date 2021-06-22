package com.example.demo.controller;

import com.example.demo.models.UserModel;
import com.example.demo.request.UserUpdatePasswordRequest;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findUserById(@PathVariable Long id){

        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<UserModel> findUserById(@PathVariable String name){

        return ResponseEntity.ok(userService.findUserByName(name));
    }

    @GetMapping("/list")
    public List<UserModel> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/list/{name}")
    public ResponseEntity<List<UserModel>> findUsersByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUsersByNameContains(name));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserModel userModel){
        Long id = this.userService.saveUser(userModel).getId();
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity deleteUser(@RequestBody UserUpdatePasswordRequest user){
        userService.updatePasswordById(user.getPassword(), user.getId());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
