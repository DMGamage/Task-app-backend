package com.example.taskappbackend.service.custom;

import com.example.taskappbackend.dto.UserDTO;
import com.example.taskappbackend.service.SuperService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends SuperService, UserDetailsService {
    void createNewUserAccount(UserDTO userDTO);

    UserDTO verifyUser(String username, String password);

    UserDTO getUserAccountDetails(String username);

    void updateUserAccountDetails(UserDTO userDTO);

    void deleteUserAccount(String username);
}
