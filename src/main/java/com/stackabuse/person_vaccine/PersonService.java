package com.stackabuse.person_vaccine;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<Person> getALLPersons() {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> getPersonId(Long personId) throws Exception {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Phone " + personId + " not found"));

        return ResponseEntity.ok().body(person);
    }

    public Person createPerson(Person person){
        try {
            personRepository.save(person);
            System.out.println("person added");

        }catch (Exception e){
            System.out.println(e);}
        return person;
    }


    public ResponseEntity<Person> updatePerson(Person person){
        final Person updatePerson = personRepository.save(person);
        return ResponseEntity.ok(updatePerson);
    }


    public Map<String, Boolean> deletePerson(Person person){
        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
