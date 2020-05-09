package dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
public class UserDetails extends BaseEntity {

    @Column
    private Sex sex;

    @Column
    private int age;

    @Column(name = "phone_number")
    private Long phoneNumber;
}
