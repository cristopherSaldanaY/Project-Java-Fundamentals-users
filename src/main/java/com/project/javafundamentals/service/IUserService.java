package com.project.javafundamentals.service;

import com.project.javafundamentals.model.dto.UserRequest;
import com.project.javafundamentals.model.dto.UserResponse;
import com.project.javafundamentals.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    List<UserResponse> getUsers();

    UserResponse getUser(UUID id);

    UserResponse createUser(UserRequest userRequest);

    UserResponse updatedUser(UUID id, UserRequest userRequest);

    UserResponse deleteUser(UUID id);
}
