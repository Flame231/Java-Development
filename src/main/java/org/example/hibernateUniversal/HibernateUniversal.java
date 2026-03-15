package org.example.hibernateUniversal;

import org.hibernate.SessionFactory;

import java.io.Serializable;

public interface HibernateUniversal<T> {

    T save(T t, SessionFactory sessionFactory);

    T get(Serializable id, SessionFactory sessionFactory);

    T update(Serializable id,T t,SessionFactory sessionFactory);
}
