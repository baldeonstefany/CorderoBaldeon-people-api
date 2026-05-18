package com.stefanydev.case_api.dto;

import lombok.Data;
import java.util.List;

//Esta clase RandomUserResponseDto tiene varias clases dentros
@Data
public class RandomUserResponseDto {

    // Estos elementos va representar cada persona.
    private List<Result> results;

    @Data
    public static class Result {
        private Name name;
        private String gender;
        private Location location;
        private String email;
        private Dob dob;
        private Picture picture;
    }

    @Data
    public static class Name {
        private String title;
        private String first;
        private String last;
    }

    @Data
    public static class Location {
        private String city;
        private String country;
    }

    @Data
    public static class Dob {
        private String date;
        private Integer age;
    }

    @Data
    public static class Picture {
        private String large;
        private String medium;
        private String thumbnail;
    }
}
