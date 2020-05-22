package dao.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "user_details")
@Data
public class UserDetails extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Min(18)
    @Max(100)
    @Column
    private int age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;
}
