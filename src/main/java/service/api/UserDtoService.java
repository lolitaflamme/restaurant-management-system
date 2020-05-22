package service.api;

import dao.entity.PassportData;
import dao.entity.User;
import dao.entity.UserDetails;
import service.model.UserDto;

import java.util.Optional;

public interface UserDtoService {
    void createUser(UserDto userDto);
    void updateUser(UserDto userDto);
}
