package com.events.riwi.infrastructure.dto.ticketDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketCreateRequestDTO {

    @NotBlank
    private String code;

    @NotBlank
    private Date initialDate;

    @NotBlank
    private Date finalDate;

    @NotBlank
    private Boolean expired;
}
