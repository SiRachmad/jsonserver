package com.sierra.jsonserver.dao;

import com.sierra.jsonserver.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID pId, Person pPerson) {
        DB.add(new Person(pId, pPerson.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID pId) {
        return DB.stream().filter(person -> person.getId().equals(pId)).findFirst();
    }

    @Override
    public int deletePersonById(UUID pId) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID pId, Person pPerson) {
        return 0;
    }
}
