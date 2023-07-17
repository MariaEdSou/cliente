package com.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
public class ClientRequestDTO {

    @NotNull
    private LocalDate date_of_birth;
    @NotEmpty
    private String name;
    @NotNull
    private Long phone;
    @Email
    private String email;
}
