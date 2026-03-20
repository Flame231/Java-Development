package org.example.hibernateNative;

import org.hibernate.SessionFactory;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

public class AppHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        PersonInt<Person> personInt = new PersonImpl<>(sessionFactory);
        Person person = personInt.add(new Person(25, 5000, "пасспорт", "АдресМОЙ!!!",
                Date.valueOf("2021-02-21"),
                Timestamp.valueOf("2011-02-12 18:34:19"),
                Time.valueOf(LocalTime.of(10, 14, 15)),
                "текст мой"));
        List<Person> list = personInt.get(Person.class);
        sessionFactory.close();
        for (Person p : list) {
            System.out.println(p.toString());
        }
    }
}
