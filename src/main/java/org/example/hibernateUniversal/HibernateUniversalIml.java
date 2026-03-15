package org.example.hibernateUniversal;

import jakarta.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.Field;

public class HibernateUniversalIml<T> implements HibernateUniversal<T> {
    SessionFactory sessionFactory;
    Class<T> tClass;

    public HibernateUniversalIml(Class<T> tClass) {
        this.tClass = tClass;
    }

    public HibernateUniversalIml(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T save(T t, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            return t;
        }
    }

    @Override
    public T get(Serializable id, SessionFactory sessionFactory) {
        T t = null;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
          t = session.getReference(tClass, id);
            transaction.commit();
            return t;
        }
    }

    @Override
    public T update(Serializable id, T t,SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T t1 = session.get(tClass, id);
            Field[] fields = tClass.getDeclaredFields();
            Long idValue= null;
            for(Field field: fields){
                field.setAccessible(true);
                if(field.isAnnotationPresent(Id.class)){
                  idValue = (Long)field.get(t1);
                  field.set(t,idValue);
                }
            }
            session.merge(t);
            transaction.commit();
            return t;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
