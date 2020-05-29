package dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "place")
@Data
public class Place extends BaseEntity {

    @Column
    private String city;

    @Column
    private String street;

    @Column(name = "building_number")
    private int buildingNumber;
}
