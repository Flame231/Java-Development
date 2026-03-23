package org.example.hibernateHierarchy.DAO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@Entity
@Table(name = "home_task")
public class HomeTask extends Task{
    @Embedded
    Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street")),
            @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    })
    Address homeAddress;
    @Column
    LocalDate startDate;
    @Column
    LocalDate endDate;
}
