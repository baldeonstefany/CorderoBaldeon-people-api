package com.stefanydev.case_api.controller;

import com.stefanydev.case_api.dto.PersonResponseDto;
import com.stefanydev.case_api.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Me va devovler la lista de 10 personas en formato JSON.
    @GetMapping("/api/persons")
    public List<PersonResponseDto> getPeople() {
        return personService.getPeople();
    }
}
