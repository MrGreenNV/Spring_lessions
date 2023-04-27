package ru.averkiev.springlesson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.averkiev.springlesson.models.Item;
import ru.averkiev.springlesson.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

    List<Item> findByName(String name);
    List<Item> findByOwner(Person owner);

}
