package ru.averkiev.springlesson.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.averkiev.springlesson.model.Person;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    JDBC API
//    *****************
//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "postgres";
//
//    private static Connection connection;
//
//    {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonMapper());

//        JDBC API
//        ***********************
//        List<Person> people = new ArrayList<>();
//
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM person";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                String email = resultSet.getString("email");
//
//                people.add(new Person(id, name, age, email));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return people;
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);

//        JDBC API
//        **************
//        Person person = new Person();
//        try {
//
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM person WHERE id=" + id;
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()) {
//                person.setId(resultSet.getInt("id"));
//                person.setName(resultSet.getString("name"));
//                person.setAge(resultSet.getInt("age"));
//                person.setEmail(resultSet.getString("email"));
//
//                person = new Person(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getInt("age"),
//                        resultSet.getString("email")
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return person;
    }

    public void save(Person person) {

        jdbcTemplate.update("INSERT INTO person VALUES(100, ?, ?, ?)", person.getName(), person.getAge(), person.getEmail());

//        JDBC API
//        *********************
//        person.setId(PEOPLE_COUNT++);
//        people.add(person);
//        JDBC API
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "INSERT INTO person VALUES(" + 100 + ", '" + person.getName() + "', " + person.getAge() + ", '" + person.getEmail() + "')";
//            statement.executeUpdate(SQL);
//
//            PreparedStatement prSt = connection.prepareStatement("INSERT INTO person VALUES(100, ?, ?, ?)");
//
//            prSt.setString(1, person.getName());
//            prSt.setInt(2, person.getAge());
//            prSt.setString(3, person.getEmail());
//
//            prSt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);

//        JDBC API
//        ***********************
//        try {
//            PreparedStatement prSt = connection.prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");
//
//            prSt.setString(1, updatedPerson.getName());
//            prSt.setInt(2, updatedPerson.getAge());
//            prSt.setString(3, updatedPerson.getEmail());
//            prSt.setInt(4, id);
//
//            prSt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);

//        JDBC API
//        **************************
//        people.removeIf(person -> person.getId() == id);
//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "DELETE FROM person WHERE id=" + id;
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
