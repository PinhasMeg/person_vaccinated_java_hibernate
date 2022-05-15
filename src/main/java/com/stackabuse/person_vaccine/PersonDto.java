package com.stackabuse.person_vaccine;

import lombok.Data;

@Data
public class PersonDto {
    private Long Id;
    private String firstName;
    private String lastName;
    private Boolean vaccinated;
}
