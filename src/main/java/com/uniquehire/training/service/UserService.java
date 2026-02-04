package com.uniquehire.training.service;

import com.uniquehire.training.dto.UserRequestDTO;
import com.uniquehire.training.dto.UserResponseDTO;
import com.uniquehire.training.model.User;

import java.util.List;

public interface UserService {

    public User saveUser(UserRequestDTO user);

    public List<UserResponseDTO> getAllUsers();

}
