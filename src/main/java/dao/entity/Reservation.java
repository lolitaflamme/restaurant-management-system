package dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Data
public class Reservation extends BaseEntity {


    @Column
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Embedded
    private PassportData passportData;
}
