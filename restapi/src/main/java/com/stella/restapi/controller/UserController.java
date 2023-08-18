package com.stella.restapi.controller;


import com.stella.restapi.entity.User;
import com.stella.restapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String  addUser( @Valid @RequestBody  User user){

        try{
             userService.addUser(user);
        return "Successfully add the user";
        }
        catch(Exception e){
            return "User Not added";      //+e;
        }
    }


    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();

    }
    @GetMapping("/get")
    public User getUser(@RequestParam Integer id){

        return userService.getUser(id);
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<Void> updateUser(@PathVariable Integer id,@RequestBody  User user){
        userService.updateUser(id,user);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")

    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }


}
