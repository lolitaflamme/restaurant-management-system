package dao.entity;

import lombok.Data;
import web.validator.PhoneNumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity {

    @NotEmpty
    @PhoneNumberConstraint
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty
    @Column
    private String password;


    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    @OneToOne
    @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    private UserDetails userDetails;

    @Embedded
    private PassportData passportData;
}
