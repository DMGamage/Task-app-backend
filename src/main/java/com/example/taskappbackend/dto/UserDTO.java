package com.example.taskappbackend.dto;

import com.example.taskappbackend.util.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class UserDTO implements Serializable {
    @NotBlank(message = "Full name can't be empty or null")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Invalid name")
    private String fullName;
    @Null(groups = ValidationGroups.Update.class, message = "Username can't be updated")
    @NotBlank(message = "Username can't be empty or null", groups = ValidationGroups.Create.class)
    private String username;
    @NotEmpty(message = "Password can't be empty or null")
    @Length(min = 3, message = "Password should be at least 3 characters long")
    private String password;

}
