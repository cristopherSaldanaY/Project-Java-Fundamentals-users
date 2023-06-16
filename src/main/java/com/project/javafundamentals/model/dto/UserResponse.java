package com.project.javafundamentals.model.dto;

import com.project.javafundamentals.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String created;

    private String modified;

    private boolean isActive = true;

    public static UserResponse mapToDto(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setCreated(user.getCreated());
        userResponse.setModified(user.getModified());
        userResponse.setActive(user.isActive());

        return userResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return isActive == that.isActive && Objects.equals(id, that.id) && Objects.equals(created, that.created) && Objects.equals(modified, that.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, modified, isActive);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserResponse{");
        sb.append("id=").append(id);
        sb.append(", created='").append(created).append('\'');
        sb.append(", modified='").append(modified).append('\'');
        sb.append(", isActive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }
}
