package com.stackabuse.person_vaccine;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private ModelMapper modelMapper=new ModelMapper();

    public PersonDto getALLPersonsDto() {
        List<Person> personList=personRepository.findAll();
        PersonDto personDto=new PersonDto();

        return personDto;

    }

    public void saveAllPersonDto(PersonDto personDto){
        List<PersonDto> personDtoo=new ArrayList<>();
        Person person=modelMapper.map(personDtoo,Person.class);
        personRepository.save(person);

    }

    public ResponseEntity<Person> getPersonId(Long personId) throws Exception {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Person " + personId + " not found"));

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
