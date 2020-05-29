package service.api;

import dao.entity.User;
import service.model.UserDto;

public interface UserService {
    User createUser(UserDto userDto);
    User updateUser(UserDto userDto);
}
