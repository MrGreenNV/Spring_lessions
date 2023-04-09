package ru.averkiev.springlesson.dao;

import org.springframework.stereotype.Component;
import ru.averkiev.springlesson.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 1;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");

                people.add(new Person(id, name, age, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
        Person person = new Person();
        try {

            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person WHERE id=" + id;
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

//                person = new Person(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getInt("age"),
//                        resultSet.getString("email")
//                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    public void save(Person person) {
//        person.setId(PEOPLE_COUNT++);
//        people.add(person);

        try {
//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO person VALUES(" + 100 + ", '" + person.getName() + "', " + person.getAge() + ", '" + person.getEmail() + "')";
//            statement.executeUpdate(SQL);

            PreparedStatement prSt = connection.prepareStatement("INSERT INTO person VALUES(100, ?, ?, ?)");

            prSt.setString(1, person.getName());
            prSt.setInt(2, person.getAge());
            prSt.setString(3, person.getEmail());

            prSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {

        try {
            PreparedStatement prSt = connection.prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");

            prSt.setString(1, updatedPerson.getName());
            prSt.setInt(2, updatedPerson.getAge());
            prSt.setString(3, updatedPerson.getEmail());
            prSt.setInt(4, id);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
        try {
            Statement statement = connection.createStatement();
            String SQL = "DELETE FROM person WHERE id=" + id;
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
