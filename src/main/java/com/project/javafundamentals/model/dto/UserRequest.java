package com.project.javafundamentals.model.dto;

import com.project.javafundamentals.model.entity.Phone;
import com.project.javafundamentals.model.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotEmpty(message = "El nombre no puede estar vacío")
    @NotNull
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String name;

    @Email(message = "Debe ingresar un email valido")
    @NotNull
    private String email;

    @NotNull
    private String password;


    List<Phone> phones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(phones, that.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, phones);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", phones=").append(phones);
        sb.append('}');
        return sb.toString();
    }

    public static User mapToEntity(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.name);
        user.setEmail(userRequest.email);
        user.setPassword(userRequest.password);
        user.setPhones(userRequest.phones);

        return user;
    }
}
