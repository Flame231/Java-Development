package org.example.hibernateHierarchy.DAO;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("WorkTask")
public class WorkTask extends Task {
    private int cost;
}
