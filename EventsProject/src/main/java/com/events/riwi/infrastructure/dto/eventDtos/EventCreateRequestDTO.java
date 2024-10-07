package com.events.riwi.infrastructure.dto.eventDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventCreateRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String address;

    @NotBlank
    private Date initialDate;

    @NotBlank
    private Date finalDate;

    @NotBlank
    private Long capacity;
}
