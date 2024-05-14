package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User user){
        User savedUser = this.userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = this.userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    // get all
    @GetMapping("/all")
    public  ResponseEntity<List<User>> getUsers(){
        List<User> userList =  this.userService.getUsers();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
    //update user by id
    @PatchMapping("/update/{id}")
    public  ResponseEntity<User> updateUser(@PathVariable("id") Long userId , @RequestBody User user){
        User updateUser = this.userService.updateUserById(userId,user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    // delete user by id
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        this.userService.deleteUserById(userId);
        return new ResponseEntity<>("delete item",HttpStatus.OK);
    }
}
