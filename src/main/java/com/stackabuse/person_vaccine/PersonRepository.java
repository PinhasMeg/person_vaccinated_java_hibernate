package com.stackabuse.person_vaccine;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Person repository.
 *
 * @author Pinhas Meguideche
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
  
}
