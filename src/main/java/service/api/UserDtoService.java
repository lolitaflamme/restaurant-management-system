package service.api;

import service.model.UserDto;

public interface UserDtoService {
    void createUser(UserDto userDto);
    void updateUser(UserDto userDto);
}
