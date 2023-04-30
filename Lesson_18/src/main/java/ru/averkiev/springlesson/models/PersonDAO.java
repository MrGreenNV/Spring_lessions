package ru.averkiev.springlesson.models;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlusOne() {
        Session session = entityManager.unwrap(Session.class);

//        // 1 запрос. Получим всех людей.
//
//        List<Person> people = session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
//
//        // N запросов
//
//        for (Person person: people) {
//            System.out.println("Person " + person.getName() + " has: " + person.getItems());
//        }

        List<Person> people = session.createQuery("SELECT p FROM Person p LEFT JOIN FETCH p.items", Person.class).getResultList();

        for (Person person : people) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
    }
}
