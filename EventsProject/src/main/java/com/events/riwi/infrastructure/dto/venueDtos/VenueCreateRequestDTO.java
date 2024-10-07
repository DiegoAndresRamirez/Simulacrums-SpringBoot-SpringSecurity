package com.events.riwi.infrastructure.dto.venueDtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueCreateRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String city;
}
