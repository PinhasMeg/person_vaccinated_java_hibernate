package com.stackabuse.person_vaccine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The type Person controller.
 *
 * @author Pinhas Meguideche
 */
@RestController
@RequestMapping("/api/v1")
public class PersonControler {

  @Autowired
  private PersonRepository personRepository;

  /**
   * Get all persons list.
   *
   * @return the list
   */
  @GetMapping("/persons")   // GET Method for reading operation
  public List<Person> getALLPersons() {
    return personRepository.findAll();
  }

  /**
   * Gets persons by id.
   *
   * @param personId the person id
   * @return the phones by id
   * @throws Exception
   */
  @GetMapping("/persons/{id}")    // GET Method for Read operation
  public ResponseEntity<Person> getPersonId(@PathVariable(value = "id") Long personId)
      throws Exception {

    Person person = personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Phone " + personId + " not found"));
    return ResponseEntity.ok().body(person);
  }

  /**
   * Create person.
   *
   * @param person the person
   * @return the person
   */
  @PostMapping("/persons")     // POST Method for Create person
  public Person createPerson(@Valid @RequestBody Person person) {
    try {
      personRepository.save(person);
      System.out.println("person added");

    }catch (Exception e){
      System.out.println(e);}
            return person;
  }

  /**
   * Update person response entity.
   *
   * @param personId the phone id
   * @param personDetails the person details
   * @return the response entity
   * @throws Exception
   */
  @PutMapping("/persons/{id}")    // PUT Method for Update operation
  public ResponseEntity<Person> updatePerson(
      @PathVariable(value = "id") Long personId, @Valid @RequestBody Person personDetails)
      throws Exception {

    Person person = personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Perso " + personId + " not found"));

    person.setFirst_name(personDetails.getFirst_name());
    person.setLast_name(personDetails.getLast_name());
    person.setVaccinated(personDetails.getVaccinated());

    final Person updatePerson = personRepository.save(person);
    return ResponseEntity.ok(updatePerson);
  }

  /**
   * Delete person map.
   *
   * @param personId the person id
   * @return the map of the deleted person
   * @throws Exception the exception
   */
  @DeleteMapping("/person/{id}")    // DELETE Method for Delete operation
  public Map<String, Boolean> deletePhone(@PathVariable(value = "id") Long personId) throws Exception {
    Person person = personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Person " + personId + " not found"));

    personRepository.delete(person);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
