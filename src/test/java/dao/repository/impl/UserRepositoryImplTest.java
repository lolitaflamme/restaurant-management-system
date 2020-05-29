package dao.repository.impl;

import dao.entity.PassportData;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRepositoryImplTest {
    private SessionFactory sessionFactory;
    PassportDataRepositoryImpl passportDataRepository = new PassportDataRepositoryImpl(sessionFactory);

    @Ignore
    public void savePassportData(){
        String passportNumber = "passportNumber";
        String identificationNumber = "identificationNumber";

        PassportData passportData = new PassportData();
        passportData.setPassportNumber(passportNumber);
        passportData.setIdentificationNumber(identificationNumber);

        passportDataRepository.savePassportData(passportData);

        assertEquals(passportData.getIdentificationNumber(), identificationNumber);
        assertEquals(passportData.getPassportNumber(), passportNumber);
    }
}
