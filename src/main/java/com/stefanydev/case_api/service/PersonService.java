package com.stefanydev.case_api.service;

import com.stefanydev.case_api.dto.PersonResponseDto;
import com.stefanydev.case_api.dto.RandomUserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// La logica de negocio
@Service
public class PersonService {

    private static final String RANDOM_USER_API_URL = "https://randomuser.me/api/?results=10";
    private final RestTemplate restTemplate;

    public PersonService() {
        // peticiones HTTP a mi API externa que es RandomUser.
        this.restTemplate = new RestTemplate();
    }

    public List<PersonResponseDto> getPeople() {

        RandomUserResponseDto response = restTemplate.getForObject(
                RANDOM_USER_API_URL,
                RandomUserResponseDto.class
        );

        List<PersonResponseDto> people = new ArrayList<>();

        if (response == null || response.getResults() == null) {
            return people;
        }

        for (RandomUserResponseDto.Result result : response.getResults()) {

            PersonResponseDto person = mapToPersonResponse(result);
            people.add(person);
        }

        return people;
    }

    private PersonResponseDto mapToPersonResponse(RandomUserResponseDto.Result result) {

        String fullName = result.getName().getFirst() + " " + result.getName().getLast();
        String location = result.getLocation().getCity() + ", " + result.getLocation().getCountry();
        String birthDate = formatBirthDate(result.getDob().getDate());

        return new PersonResponseDto(
                fullName,
                result.getGender(),
                location,
                result.getEmail(),
                birthDate,
                result.getPicture().getLarge()
        );
    }

    private String formatBirthDate(String date) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        return offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
