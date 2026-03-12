package org.example.daoReflection.dto.car;

import org.example.daoReflection.Annotations.Column;
import org.example.daoReflection.Annotations.PrimaryKey;
import org.example.daoReflection.Annotations.Table;

@Table("car")
public class Car {
    @PrimaryKey("id")
    private long id;
    @Column("doubleValue")
    private double doubleColumn;
    @Column("month")
    private String name;
    @Column("type")
    private String type;

    public Car() {
        name = "name1222";
        type = "type1222";
    }

    public Car(double doubleColumn, String name, String type) {
        this.doubleColumn = doubleColumn;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", doubleColumn=" + doubleColumn +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
