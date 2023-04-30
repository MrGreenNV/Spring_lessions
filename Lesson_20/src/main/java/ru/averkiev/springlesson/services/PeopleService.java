package ru.averkiev.springlesson.services;

import org.springframework.stereotype.Service;
import ru.averkiev.springlesson.models.Person;
import ru.averkiev.springlesson.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }
}
