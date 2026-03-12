package org.example.daoReflection;

import org.example.daoReflection.dao.DAO;
import org.example.daoReflection.dao.DAOImpl;
import org.example.daoReflection.dto.person.Person;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class App {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        DAO<Person> dao = new DAOImpl<Person>(Person.class);
       Person person = dao.save(new Person(23,5000,"пасспорт1","адрес1", new Date(2025,12,5),
               Timestamp.valueOf("2024-03-18 13:30:25"), new Time(14,15,45),"текст3!!!!"));
        System.out.println(dao.get(person.getId()));

    }
}
