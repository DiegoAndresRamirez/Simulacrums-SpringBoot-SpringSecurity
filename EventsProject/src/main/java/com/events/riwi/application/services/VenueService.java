package com.events.riwi.application.services;

import com.events.riwi.application.interfaces.IVenueService;
import com.events.riwi.domain.models.Venue;
import com.events.riwi.domain.persistence.VenueRepository;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateRequestDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService implements IVenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public VenueCreateResponseDTO createVenue(VenueCreateRequestDTO venueCreateRequestDTO) {
        Venue venueExists = venueRepository.findByName(venueCreateRequestDTO.getName());
        if (venueExists != null) {
            return VenueCreateResponseDTO.builder()
                    .message("Venue already exists")
                    .build();
        }
        Venue newVenue = Venue.builder()
                .name(venueCreateRequestDTO.getName())
                .address(venueCreateRequestDTO.getAddress())
                .city(venueCreateRequestDTO.getCity())
                .build();
        venueRepository.save(newVenue);


        return VenueCreateResponseDTO.builder()
                .message("Venue created with the name: " + venueCreateRequestDTO.getName())
                .build();
    }

    @Override
    public List<VenueCreateRequestDTO> getAllVenues() {
        List<VenueCreateRequestDTO> venues = new ArrayList<>();

        venueRepository.findAll().forEach(venue -> {
            venues.add(VenueCreateRequestDTO.builder()
                    .name(venue.getName())
                    .address(venue.getAddress())
                    .city(venue.getCity())
                    .build());
        });
        if (venues.isEmpty()) {
            throw new UsernameNotFoundException("Venue not found");
        }
        return venues;
    }

    @Override
    public VenueCreateRequestDTO getVenueById(Long id) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if (venue == null) {
            throw new UsernameNotFoundException("Venue not found");
        }
        return VenueCreateRequestDTO.builder()
                .name(venue.getName())
                .address(venue.getAddress())
                .city(venue.getCity())
                .build();
    }

    @Override
    public String deleteVenue(Long id) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if (venue == null) {
            throw new UsernameNotFoundException("Venue not found");
        }
        venueRepository.deleteById(id);
        return "Venue deleted successfully";
    }

    @Override
    public String updateVenue(Long id, VenueCreateRequestDTO venueCreateRequestDTO) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if (venue == null) {
            throw new UsernameNotFoundException("Venue not found");
        }

        venue.setId(id);
        venue.setName(venueCreateRequestDTO.getName());
        venue.setAddress(venueCreateRequestDTO.getAddress());
        venue.setCity(venueCreateRequestDTO.getCity());

        venueRepository.save(venue);
        return "Venue updated successfully";
    }
}
