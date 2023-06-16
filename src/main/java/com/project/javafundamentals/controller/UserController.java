package com.project.javafundamentals.controller;

import com.project.javafundamentals.exception.ErrorDetail;
import com.project.javafundamentals.model.dto.UserRequest;
import com.project.javafundamentals.model.dto.UserResponse;
import com.project.javafundamentals.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest){

        try{
            UserResponse userResponse = userService.createUser(userRequest);

            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } catch (RuntimeException e){

            ErrorDetail errorDetail = new ErrorDetail(HttpStatus.CONFLICT.value(), e.getMessage());
            return new ResponseEntity<>(errorDetail, HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers(){

        try{
            List<UserResponse> userResponses = userService.getUsers();

            return new ResponseEntity<>(userResponses, HttpStatus.OK);

        } catch (RuntimeException exception){

            ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(), exception.getMessage());
            System.out.println(errorDetail);

            return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") UUID id){

        try{
            UserResponse userResponse = userService.getUser(id);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }catch (RuntimeException exception){
            ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(), exception.getMessage());

            return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") UUID id, @RequestBody UserRequest userRequest){

        try{
            UserResponse userResponse = userService.updatedUser(id, userRequest);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }catch (RuntimeException exception){

            ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(), exception.getMessage());
            return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id){

        try{
            UserResponse userResponse = userService.deleteUser(id);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }catch (RuntimeException exception){
            ErrorDetail errorDetail = new ErrorDetail(HttpStatus.NOT_FOUND.value(), exception.getMessage());

            return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
        }


    }


}
