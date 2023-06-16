package com.project.javafundamentals.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {

    private int status;
    private String message;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDetail that = (ErrorDetail) o;
        return status == that.status && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorDetail{");
        sb.append("status=").append(status);
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static List<ErrorDetail> errorMap(List<FieldError> fieldErrors){

        List<ErrorDetail> errorResult = new ArrayList<>();

        for (FieldError fieldError : fieldErrors){
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
            errorDetail.setMessage(fieldError.getDefaultMessage());

            errorResult.add(errorDetail);
        }

        return errorResult;
    }


}
