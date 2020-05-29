package dao.repository.impl;

import dao.entity.User;
import dao.repository.api.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.api.UserService;
import service.impl.UserServiceImpl;
import service.model.UserDto;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplIntegrationTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void createUser() {
        String phoneNumber = "number";
        String password = "password";
        Integer age = 33;

        UserDto userDto = new UserDto();
        userDto.setPhoneNumber(phoneNumber);
        userDto.setPassword(passwordEncoder.encode(password));
        userDto.setAge(age);

        User testUser = new User();
        testUser.setPhoneNumber(userDto.getPhoneNumber());
        testUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        testUser.setAge(userDto.getAge());

        when(userRepository.saveUser(any()))
        .thenReturn(testUser);

        User user = userService.createUser(userDto);

        assertEquals(user.getPhoneNumber(), phoneNumber);
        assertEquals(user.getAge(), age);
    }
}
