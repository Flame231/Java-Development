package org.example.daoReflection.dto.car;

import org.example.daoReflection.dao.DAOImpl;

public class CarDAOImpl extends DAOImpl<Car> implements CarDAO {
    public CarDAOImpl(Class<Car> tclass) {
        super(tclass);
    }
}
