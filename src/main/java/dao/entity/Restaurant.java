package dao.entity;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "my-cache")
public class Restaurant extends BaseEntity {

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "restaurant_place",
            joinColumns = @JoinColumn(name = "fk_restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_place_id")
    )
    private List<Place> places;
}
