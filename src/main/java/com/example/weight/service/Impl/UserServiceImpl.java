package com.example.weight.service.Impl;



import org.springframework.stereotype.Service;

import com.example.weight.model.User;
import com.example.weight.model.dto.UserDTO;
import com.example.weight.repository.UserRepository;
import com.example.weight.service.UserServiceDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserServiceDAO{
    private final UserRepository repository;

    public User save(User user){
    return repository.save(user);
    }

    public User create(UserDTO dto){
    double bmr = 88.36 + (13.4 * dto.getWeight()) + (4.8 * dto.getHeight()) - (5.7 * dto.getAge());
    double calNorm = 0;
    switch (dto.getTarget()) {
        case Weight_Loss -> calNorm = bmr * 0.85;
        case Maintenance -> calNorm = bmr;
        case Mass_Gain -> calNorm = bmr * 1.15;
    }
    

    User user  = User.builder()
    .name(dto.getName())
    .email(dto.getEmail())
    .age(dto.getAge())
    .weight(dto.getWeight())
    .height(dto.getHeight())
    .target(dto.getTarget())
    .calorie_norm(calNorm)
    .build();

        return save(user);
    }

}
