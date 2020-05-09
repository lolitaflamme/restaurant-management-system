package dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class PassportData {

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "identification_number")
    private String identificationNumber;
}
