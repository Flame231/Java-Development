package org.example.hibernateHierarchy.DAO;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@Table(name = "work_task")
public class WorkTask extends Task{
    int cost;
}
