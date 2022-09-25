package com.smarttechnologies.servicesqatar.Controller;


import com.smarttechnologies.servicesqatar.Entities.User;
import com.smarttechnologies.servicesqatar.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

         @RestController
         @RequestMapping("/users")
         public class UserResource {

        private final UserService userService;
   @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
        public ResponseEntity<List<User>> getAllUsers () {
            List<User> users = userService.findAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        @GetMapping("/find/{idUser}")
        public ResponseEntity<User> getUserById (@PathVariable("idUser") Long idUser) {
          User user = userService.findUserById(idUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<User> addUser(@RequestBody User user) {
            User newUser = userService.addUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<User> updateUser(@RequestBody User user) {
            User updateUser=userService.updateUser(user);
            return new ResponseEntity<>(updateUser, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{idUser}")
        public ResponseEntity<?> deleteUser(@PathVariable("idUser") Long idUser) {
             userService.deleteUser(idUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

