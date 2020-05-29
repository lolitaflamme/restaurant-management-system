package service.impl;

import dao.entity.PassportData;
import dao.entity.Role;
import dao.entity.User;
import dao.entity.UserDetails;
import dao.repository.api.PassportDataRepository;
import dao.repository.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.api.UserService;
import service.model.UserDto;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger log = Logger.getLogger(Logger.class);

    private final UserRepository userRepository;
    private final PassportDataRepository passportDataRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAge(userDto.getAge());
        user.setRole(Role.USER);
        userRepository.saveUser(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(UserDto userDto) {
        User user = userRepository.getUserByPhoneNumber(userRepository.getCurrentUserName()).get();
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPassword(user.getPassword());
        userDto.setAge(user.getAge());

        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDto.getFirstName());
        userDetails.setSecondName(userDto.getSecondName());
        userDetails.setGender(userDto.getGender());
        user.setUserDetails(userDetails);
        userRepository.saveUserDetails(userDetails);
        PassportData passportData = new PassportData();
        passportData.setPassportNumber(userDto.getPassportNumber());
        passportData.setIdentificationNumber(userDto.getIdentificationNumber());
        user.setPassportData(passportData);
        passportDataRepository.savePassportData(passportData);
        userRepository.saveUser(user);
        return user;
    }
}
