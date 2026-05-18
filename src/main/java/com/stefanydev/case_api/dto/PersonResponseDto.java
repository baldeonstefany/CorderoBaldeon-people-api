package com.stefanydev.case_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDto {

    private String fullName;
    private String gender;
    private String location;
    private String email;
    private String birthDate;
    private String photo;
}
