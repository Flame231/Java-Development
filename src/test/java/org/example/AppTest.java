
package org.example;

import org.example.hibernateNative.HibernateUtils;
import org.example.hibernateNative.Person;
import org.example.hibernateNative.PersonImpl;
import org.example.hibernateNative.PersonInt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    public static final int age = 21;
    public static final String asc = "asc";
    public static final String desc = "desc";
    public static final String expression = "Не выполнено условие фильтрации для: ";

    @Test
    void AddPerson() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        PersonInt<Person> personInt = new PersonImpl<>(sessionFactory);
        Person person = personInt.add(new Person(25, 5000, "пасспорт", "АдресМОЙ!!!",
                Date.valueOf("2021-02-21"),
                Timestamp.valueOf("2011-02-12 18:34:19"),
                Time.valueOf(LocalTime.of(10, 14, 15)),
                "текст мой"));
        long id = person.getId();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Optional<Person> optionalPerson = session.createQuery("from Person p where p.id = :val").setParameter("val", id).uniqueResultOptional();
            assertTrue(optionalPerson.isPresent(), "id объекта в БД не найден!");
        }
    }

    @Test
    void GetPerson() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person1 = new Person(24, "тестовое значение", Timestamp.valueOf("2024-02-12 18:34:19"));
            Person person2 = new Person(22, "тестовое значение", Timestamp.valueOf("2022-02-12 16:34:19"));
            session.persist(person1);
            session.persist(person2);
            session.getTransaction().commit();
            List<Person> list = session.createQuery("from Person p where p.age >" + age + " order by dateTimeCreate " + desc).list();
            ageFilter(person1, list);
            ageFilter(person2, list);
            Iterator<Person> iterator = list.iterator();
            for (Person person : list)
                while (iterator.hasNext()) {
                    Person p1 = iterator.next();
                    if (iterator.hasNext()) {
                        Person p2 = iterator.next();
                        Timestamp t1 = p1.getDateTimeCreate();
                        Timestamp t2 = p2.getDateTimeCreate();
                        if (!t1.equals(t2)) {
                            assertTrue(t1.after(t2), "!!!");
                        }
                    }

                }
        }

    }

    public void ageFilter(Person person, List<Person> list) {
        if (person.getAge() > age) {
            assertTrue(list.contains(person), expression);
        } else {
            assertTrue(false, expression + person);
        }
    }
}
