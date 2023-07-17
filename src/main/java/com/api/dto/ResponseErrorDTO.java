package com.api.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ResponseErrorDTO {

    private HttpStatusCode code;
    private String message;
}
