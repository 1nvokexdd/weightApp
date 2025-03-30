package com.example.weight;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.weight.model.Meal;
import com.example.weight.model.User;
import com.example.weight.repository.MealRepository;
import com.example.weight.repository.UserRepository;
import com.example.weight.service.Impl.MealServiceImpl;
import com.example.weight.service.Impl.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private MealRepository mealRepository;
    @InjectMocks
    private MealServiceImpl mealServiceImpl;

    

    @Test
    void createUserTest(){
    User mockUser = User.builder()
                .name("Test User")
                .email("test@example.com")
                .age(42)
                .build();

    when(userRepository.save(any(User.class))).thenReturn(mockUser);

    User savedUser = userService.save(mockUser);

    assertThat(savedUser.getName()).isEqualTo("Test User");
    verify(userRepository,times(1)).save(any(User.class));
    }


    @Test
    void createMealTest(){
    Meal mockMeal = Meal.builder()
    .name("hamburger")
    .calories(100)
    .proteins(100)
    .carbs(100)
    .fats(100)
    .build();

    when(mealRepository.save(any(Meal.class))).thenReturn(mockMeal);

   Meal savedMock  =  mealServiceImpl.save(mockMeal);

    assertThat(savedMock.getName()).isEqualTo("hamburger");
    assertThat(savedMock.getCalories()).isEqualTo(100);
    assertThat(savedMock.getProteins()).isEqualTo(100);
    verify(mealRepository ,times(1)).save(any(Meal.class));
    }

}
