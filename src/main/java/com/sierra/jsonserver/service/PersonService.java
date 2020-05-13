package com.sierra.jsonserver.service;

import com.sierra.jsonserver.dao.PersonDao;
import com.sierra.jsonserver.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao pPersonDao) {
        this.personDao = pPersonDao;
    }

    public int addPerson(Person pPerson) {
        return personDao.insertPerson(pPerson);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID pId) {
        return personDao.selectPersonById(pId);
    }
}
