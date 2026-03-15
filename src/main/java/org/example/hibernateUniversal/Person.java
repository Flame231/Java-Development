package org.example.hibernateUniversal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // КРИТИЧЕСКИ ВАЖНО!
    @Column(name = "id")
    private long id;  // Используйте Long вместо long (объектный тип)

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "pasport")
    private String pasport;

    @Column(name = "adress")
    private String adress;

    @Column(name = "dateofBirthday")
    private Date dateofBirthday;

    @Column(name = "dateTimeCreate")
    private Timestamp dateTimeCreate;

    @Column(name = "timetoLunch")
    private Time timetoLunch;

    @Column(name = "letter")
    private String letter;

    // Конструктор без id
    public Person(int age, int salary, String pasport, String adress,
                  Date dateofBirthday, Timestamp dateTimeCreate,
                  Time timetoLunch, String letter) {
        this.age = age;
        this.salary = salary;
        this.pasport = pasport;
        this.adress = adress;
        this.dateofBirthday = dateofBirthday;
        this.dateTimeCreate = dateTimeCreate;
        this.timetoLunch = timetoLunch;
        this.letter = letter;
    }

    public Person(int age, String pasport, Timestamp dateTimeCreate) {
        this.age = age;
        this.pasport = pasport;
        this.dateTimeCreate = dateTimeCreate;
    }

    @Override
    public boolean equals(Object p) {
        Person person = (Person)p;
      return this.id==person.getId();
    }
}