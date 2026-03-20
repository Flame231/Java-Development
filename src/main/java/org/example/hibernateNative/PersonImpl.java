package org.example.hibernateNative;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonImpl<Person> implements PersonInt<Person> {
    SessionFactory sessionFactory;

    public PersonImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Person add(Person person) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();
            return person;
        }
    }

    @Override
    public List<Person> get(Class<Person> personClass) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Person> list = session.createQuery("from Person p where p.age >21 " +
                            "order by dateTimeCreate desc")
                    .list();
            transaction.commit();
            return list;
        }
    }
}
