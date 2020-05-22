package dao.repository.impl;

import dao.entity.PassportData;
import dao.entity.User;
import dao.entity.UserDetails;
import dao.repository.api.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Optional<User> getUserByPhoneNumber(String phoneNumber) {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from " + User.class.getSimpleName() + " e where e.phoneNumber = :phoneNumber", User.class)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList()
                .stream()
                .findFirst();
    }

    public User saveUser(User user) {
        sessionFactory.getCurrentSession()
                .save(user);
        return user;
    }

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        sessionFactory.getCurrentSession()
                .save(userDetails);
        return userDetails;
    }

    @Override
    public PassportData savePassportData(PassportData passportData) {
        sessionFactory.getCurrentSession()
                .save(passportData);
        return passportData;
    }
}
