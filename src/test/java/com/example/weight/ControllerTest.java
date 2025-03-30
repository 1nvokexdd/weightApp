package com.example.weight;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ObjectInputFilter.Status;
import java.net.BindException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.weight.controller.UserController;
import com.example.weight.model.User;
import com.example.weight.model.dto.UserDTO;
import com.example.weight.model.enums.Target;
import com.example.weight.service.Impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    UserServiceImpl userService;
    @InjectMocks
    UserController userController;
    
    @Test
    void testCreateUser(){
    
        UserDTO dto = UserDTO.builder()
        .name("test user")
        .age(22)
        .email("test@gmail.com")
        .weight(160)
        .height(160)
        .target(Target.Maintenance)
        .build();

        User createdUser = User.builder()
                .id(1L)
                .name("test user")
                .age(22)
                .build();
    when(userService.create(any(UserDTO.class))).thenReturn(createdUser);


    ResponseEntity<?> response = userController.addUser(dto);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isNotNull();
    verify(userService, times(1)).create(any(UserDTO.class));
    }

}
