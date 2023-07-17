package com.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteResponseDTO {


    private Long id;
    private LocalDate date_of_birth;
    private String name;
    private Long phone;
    private String email;
}
