package com.sierra.jsonserver.dao;

import com.sierra.jsonserver.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person pPerson);

    default int insertPerson(Person pPerson) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, pPerson);
    }

    List<Person> selectAllPeople();
    Optional<Person> selectPersonById(UUID pId);

    int deletePersonById(UUID pId);
    int updatePersonById(UUID pId, Person pPerson);
}
