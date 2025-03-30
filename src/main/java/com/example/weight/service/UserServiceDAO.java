package com.example.weight.service;

import com.example.weight.model.User;
import com.example.weight.model.dto.UserDTO;

public interface  UserServiceDAO {
    public User save(User user);

    public User create(UserDTO dto);
    
    
}
