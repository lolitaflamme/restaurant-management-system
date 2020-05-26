package service.model;

import dao.entity.Gender;
import lombok.Data;
import web.validator.PhoneNumberConstraint;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {
    @NotEmpty
    @PhoneNumberConstraint
    private String phoneNumber;

    @NotEmpty
    private String password;

    private String passportNumber;

    private String identificationNumber;

    private String firstName;

    private String secondName;

    private Gender gender;

    @Min(18)
    @Max(100)
    private int age;
}
