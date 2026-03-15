package org.example.hibernateNative;

import java.util.List;

public interface PersonInt<Person> {
    Person add(Person persons);

    List<Person> get(Class<Person> personClass);
}
