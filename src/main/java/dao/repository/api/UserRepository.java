package dao.repository.api;

import dao.entity.PassportData;
import dao.entity.User;
import dao.entity.UserDetails;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserByPhoneNumber(String phoneNumber);

    User saveUser (User user);

    UserDetails saveUserDetails (UserDetails userDetails);

    String getCurrentUserName ();
}
