package ru.averkiev.springlesson.dao;

import org.springframework.stereotype.Component;
import ru.averkiev.springlesson.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 1;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(PEOPLE_COUNT++, "Tom", 20, "tom@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Bob", 25, "bob@yandex.ru"));
        people.add(new Person(PEOPLE_COUNT++, "Bred", 27, "bred@rambler.com"));
        people.add(new Person(PEOPLE_COUNT++, "Jack", 30, "jack@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++, "Katy", 23, "katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
