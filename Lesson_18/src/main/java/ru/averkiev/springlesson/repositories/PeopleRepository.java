package ru.averkiev.springlesson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.averkiev.springlesson.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
