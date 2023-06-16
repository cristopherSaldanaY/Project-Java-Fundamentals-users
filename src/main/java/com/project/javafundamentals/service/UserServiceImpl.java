package com.project.javafundamentals.service;

import com.project.javafundamentals.model.dto.UserRequest;
import com.project.javafundamentals.model.dto.UserResponse;
import com.project.javafundamentals.model.entity.User;
import com.project.javafundamentals.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        if(users.size() > 0){
            List<UserResponse> userResponses = new ArrayList<>();

            for(User user : users){
                userResponses.add(UserResponse.mapToDto(user));
            }

            return userResponses;
        }

        throw  new RuntimeException("No existen registros");

    }

    @Override
    public UserResponse getUser(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isEmpty()){
            User user = userOptional.get();
            UserResponse userResponse = UserResponse.mapToDto(user);

            return userResponse;
        }

        throw new RuntimeException("Usuario no existe");
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {


        if(userRepository.existsByEmail(userRequest.getEmail())){
           throw new RuntimeException("El correo " + userRequest.getEmail() + " ya esta registrado");
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);

        User user = UserRequest.mapToEntity(userRequest);
        user.setCreated(formattedDateTime);
        user.setModified(formattedDateTime);

        User userSaved =  userRepository.save(user);

        return UserResponse.mapToDto(userSaved);
    }

    @Override
    public UserResponse updatedUser(UUID id, UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isPresent()){
            User user = userOptional.get();

            boolean emailChanged = !user.getEmail().equals(userRequest.getEmail());

            if(emailChanged && userRepository.existsByEmail(userRequest.getEmail())){
                throw new RuntimeException("El correo " + userRequest.getEmail() + " ya está registrado");
            }

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = localDateTime.format(dateTimeFormatter);

            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setPhones(userRequest.getPhones());

            user.setModified(formattedDateTime);

            userRepository.save(user);

            return UserResponse.mapToDto(user);

        }

        throw new RuntimeException("Usuario no existe");
    }

    @Override
    public UserResponse deleteUser(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isEmpty()){

            User user = userOptional.get();
            userRepository.deleteById(id);
            UserResponse userResponse = UserResponse.mapToDto(user);

            return userResponse;
        }

        throw new RuntimeException("Usuario no existe");

    }
}
