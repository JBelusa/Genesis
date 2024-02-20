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
    public ResponseEntity<List<UserInfo>> getUsers(@RequestParam(defaultValue = "false") boolean detail) {
        List<UserInfo> userList = userInfoService.getAllUsers(detail);
        if (userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id, @RequestParam(defaultValue = "false") boolean detail) {
        UserInfo userInfo = userInfoService.getUserById(id, detail);
        if (userInfo != null) {
            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> createNewUser(@RequestBody UserInfo userInfo) {
        UserInfo createdUser = userInfoService.createNewUser(userInfo);
        if (createdUser == null) {
            return new ResponseEntity<>("personID " + userInfo.getPersonID() + " se nepodařilo vytvořit", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserInfo userinfo) {
        if (userInfoService.getUserById(id, true) != null) {
            userInfoService.updateUser(id, userinfo);
            return new ResponseEntity<>("Nové jméno a přijmení uživatele: " + userinfo.getName() + " " + userinfo.getSurname(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Uživatel s id: " + id + " nebyl nalezen", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

        if (userInfoService.deleteUser(id)) {
            return new ResponseEntity<>("Uživatel s id " + id + " byl úspěšně vymazán.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Uživatele s id " + id + " nelze vymazat - nenachází se v databázi.", HttpStatus.BAD_REQUEST);
        }
    }
}


