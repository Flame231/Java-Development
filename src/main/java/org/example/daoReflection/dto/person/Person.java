package org.example.daoReflection.dto.person;

import org.example.daoReflection.Annotations.Column;
import org.example.daoReflection.Annotations.PrimaryKey;
import org.example.daoReflection.Annotations.Table;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table("person")
public class Person {
    @PrimaryKey("id")
    long id;
    @Column("age")
    int age;
    @Column("salary")
    int salary;
    @Column("pasport")
    String pasport;
    @Column("adress")
    String adress;
    @Column("dateofBirthday")
    Date dateofBirthday;
    @Column("dateTimeCreate")
    Timestamp dateTimeCreate;
    @Column("timetoLunch")
    Time timetoLunch;
    @Column("letter")
    String letter;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public Person(int age, int salary, String pasport, String adress, Date dateofBirthday, Timestamp dateTimeCreate, Time timetoLunch, String letter) {
        this.age = age;
        this.salary = salary;
        this.pasport = pasport;
        this.adress = adress;
        this.dateofBirthday = dateofBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timetoLunch = timetoLunch;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", pasport='" + pasport + '\'' +
                ", address='" + adress + '\'' +
                ", dateofBirthday=" + dateofBirthday +
                ", dateTimeCreate=" + dateTimeCreate +
                ", timetoLunch=" + timetoLunch +
                ", letter='" + letter + '\'' +
                '}';
    }
}
