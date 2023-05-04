package ru.averkiev.springlesson.services;

import org.springframework.stereotype.Service;
import ru.averkiev.springlesson.models.Person;
import ru.averkiev.springlesson.repositories.PeopleRepository;
import ru.averkiev.springlesson.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);
    }

}
