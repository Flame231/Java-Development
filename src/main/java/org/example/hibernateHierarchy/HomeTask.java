package org.example.hibernateHierarchy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@DiscriminatorValue("HomeTask")
public class HomeTask extends Task{
    Date startDate;
    Date endDate;
}
