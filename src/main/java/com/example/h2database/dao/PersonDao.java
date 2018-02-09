package com.example.h2database.dao;

import com.example.h2database.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    public Person findById(Long id) {
        return (Person) jdbcTemplate.queryForObject(
                "SELECT * FROM person WHERE id=?",
                new Object[]{id},
                new PersonRowMapper()
        );
    }

    public String deleteById(Long id) {
        return String.valueOf(jdbcTemplate.update("DELETE FROM person WHERE id=?", id));
    }

    public String insert(Person person) {
        return String.valueOf(jdbcTemplate.update("INSERT INTO person (id,name) VALUES (?,?)", person.getId(), person.getName()));
    }

    public String update(Person person) {
        return String.valueOf(jdbcTemplate.update("UPDATE person SET name = ? WHERE id = ?", person.getName(), person.getId()));
    }

}
