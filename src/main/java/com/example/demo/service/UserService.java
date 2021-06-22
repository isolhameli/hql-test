package com.example.demo.service;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    public List<UserModel> findAllUsers(){
        return userRepository.findAll();
    }

    public List<UserModel> findUsersByNameContains(String name){
        return userRepository.findUsuarioModelByName(name);
    }

    public UserModel findUserByName(String name){
        return userRepository.findByName(name).orElseThrow(() -> new UserNotFoundException("User with userName " + name + " not found."));
    }

    public UserModel saveUser(UserModel newUser){
        return userRepository.save(newUser);
    }

    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User ID " + id + " not found."));
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void updatePasswordById(String password, Long id){
        userRepository.updatePasswordById(password, id);
    }
}
