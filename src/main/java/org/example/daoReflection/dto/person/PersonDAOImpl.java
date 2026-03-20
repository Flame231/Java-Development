package org.example.daoReflection.dto.person;

import org.example.daoReflection.dao.DAOImpl;

public class PersonDAOImpl extends DAOImpl<Person> implements PersonDAO {
    public PersonDAOImpl(Class tclass) {
        super(tclass);
    }
}
