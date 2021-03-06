package com.sierra.jsonserver.api;

import com.sierra.jsonserver.model.Person;
import com.sierra.jsonserver.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person pPerson) {
        personService.addPerson(pPerson);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{pId}")
    public Person getPersonById(@PathVariable("pId") UUID pId) {
        return personService.getPersonById(pId).orElse(null);
    }
}
