package com.engeto.Genesis.controller;

import com.engeto.Genesis.model.UserInfo;

import com.engeto.Genesis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;


    @GetMapping("/users")
    public List<UserInfo> getUsers(@RequestParam(defaultValue = "false") boolean detail) {
        return userInfoService.getAllUsers(detail);
    }

    @GetMapping("/user/{id}")
    public UserInfo getUserById(@PathVariable("id") long id, @RequestParam(defaultValue = "false") boolean detail) {
        return userInfoService.getUserById(id, detail);

    }

    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody UserInfo userInfo) {
        UserInfo createdUser = userInfoService.createNewUser(userInfo);
        if (createdUser == null) {
            return new ResponseEntity<>("rozbitý",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }


    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        return userInfoService.deleteUser(id);


    }

    @GetMapping("/pokus/{id}")
    public String pokusId(@PathVariable("id") String personId) {
        return userInfoService.getStreetNameById(personId);

    }

}


