package service.impl;

import dao.entity.PassportData;
import dao.entity.Role;
import dao.entity.User;
import dao.entity.UserDetails;
import dao.repository.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service.api.UserDtoService;
import service.model.UserDto;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDtoServiceImpl implements UserDtoService {

    private final UserRepository userRepository;
    /* private final PasswordEncoder passwordEncoder;*/

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(/*passwordEncoder.encode*/(userDto.getPassword()));
        user.setRole(Role.USER);
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        PassportData passportData = new PassportData();
        passportData.setPassportNumber(userDto.getPassportNumber());
        passportData.setIdentificationNumber(userDto.getIdentificationNumber());
        userRepository.savePassportData(passportData);
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDto.getFirstName());
        userDetails.setSecondName(userDto.getSecondName());
        userDetails.setSex(userDto.getSex());
        userDetails.setAge(userDto.getAge());
        userRepository.saveUserDetails(userDetails);
    }
}
