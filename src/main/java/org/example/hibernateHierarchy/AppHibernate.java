package org.example.hibernateHierarchy;

import org.example.hibernateHierarchy.DAO.Address;
import org.example.hibernateHierarchy.DAO.HomeTask;
import org.example.hibernateHierarchy.DAO.Task;
import org.example.hibernateHierarchy.DAO.WorkTask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class AppHibernate {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Task task = Task.builder().name("name1").description("description1").build();
            HomeTask homeTask = HomeTask.builder().name("name2").description("description2")
                    .startDate(LocalDate.of(2026, 03, 12))
                    .endDate(LocalDate.of(2026, 03, 13))
                    .address(new Address("street1", "city1"))
                    .homeAddress(new Address("street2", "city2"))
                    .build();
            WorkTask workTask = WorkTask.builder().name("name3").description("description3")
                    .cost(2000).build();
            session.beginTransaction();
            session.persist(task);
            session.persist(homeTask);
            session.persist(workTask);
            session.getTransaction().commit();
        }
    }
}
