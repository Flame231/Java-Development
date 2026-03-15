package org.example.hibernateUniversal;

import org.hibernate.SessionFactory;
import org.example.hibernateUniversal.Person;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class AppHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        HibernateUniversal<Person> hibernateUniversal = new HibernateUniversalIml<>(Person.class);
        Person person = hibernateUniversal.update(170,new Person(25, 5000, "перезаписанный!", "АдресМОЙ!!!",
                Date.valueOf("2021-02-21"),
                Timestamp.valueOf("2011-02-12 18:34:19"),
                Time.valueOf(LocalTime.of(10, 14, 15)),
                "текст мой"), sessionFactory);
       /* System.out.println(person.toString());*/
       /* Person person2 = hibernateUniversal.get(person.getId(), sessionFactory);
        System.out.println(person2);*/
    }
}
