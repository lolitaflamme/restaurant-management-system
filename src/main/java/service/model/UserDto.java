package service.model;

import dao.entity.Reservation;
import dao.entity.Role;
import dao.entity.Sex;
import dao.entity.UserDetails;
import lombok.Data;
import web.validator.PhoneNumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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

    private Sex sex;

    @Min(18)
    @Max(100)
    private int age;
}
