package dao.repository.impl;

import dao.entity.PassportData;
import dao.repository.api.PassportDataRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PassportDataRepositoryImpl implements PassportDataRepository {

    private final SessionFactory sessionFactory;

    @Override
    public PassportData savePassportData(PassportData passportData) {
        sessionFactory.getCurrentSession()
                .save(passportData);
        return passportData;
    }
}
