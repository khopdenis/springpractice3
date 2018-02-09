package com.example.h2database.controller;

import com.example.h2database.dao.PersonDao;
import com.example.h2database.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/person")
    public Object findAllPersons(){
        return personDao.findAll();
    }

    @RequestMapping("/person/{id}")
    public Object findPersonById(@PathVariable("id") Long id){
        return personDao.findById(id);
    }

    @RequestMapping("/person/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        return personDao.deleteById(id);
    }

    @RequestMapping(value = "/person/insert")
    public String insert(@RequestBody Person person){
        return personDao.insert(person);
    }

    @RequestMapping(value = "/person/update")
    public String update(@RequestBody Person person){
        return personDao.update(person);
    }

}
