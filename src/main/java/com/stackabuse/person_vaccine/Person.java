package com.stackabuse.person_vaccine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * This class will represent our person and its attributes:
 * - ID
 * - First name
 * - Last name
 * - Vaccinated
 *
 * @author Pinhas Meguideche
 */
@Entity
@Table(name = "person_vaccination")   // the table in the database that will contain our person data
@EntityListeners(AuditingEntityListener.class)
public class Person {
  
  /**
   * The attributes of the person
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;    // Each person will be given an auto-generated unique identifier when stored

  @Column(name = "first_name", nullable = false)
  private String first_name;    // We will also save the name of the person

  @Column(name = "last_name", nullable = false)
  private String last_name;    // We will also save the last nme of the person

  @Column(name = "vaccinated", nullable = false)
  private Boolean vaccinated;    // We will also save the vaccinated status

  /**
   * Our getters and setters for the attributes above
   */

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Boolean getVaccinated() {
    return vaccinated;
  }

  public void setVaccinated(Boolean vaccinated) {
    this.vaccinated = vaccinated;
  }
}
