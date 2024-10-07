package com.events.riwi.infrastructure.controllers;

import com.events.riwi.application.services.VenueService;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateRequestDTO;
import com.events.riwi.infrastructure.dto.venueDtos.VenueCreateResponseDTO;
import com.events.riwi.infrastructure.interfaces.IVenueController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
public class VenueController implements IVenueController {

    @Autowired
    private VenueService venueService;

    @Override
    @PostMapping("/create")
    public ResponseEntity<VenueCreateResponseDTO> createVenue(@RequestBody VenueCreateRequestDTO venueCreateRequestDTO) {
        try{
            return ResponseEntity.status(201).body(venueService.createVenue(venueCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(VenueCreateResponseDTO.builder().message(e.getMessage()).build());
        }
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<VenueCreateRequestDTO>> getAllVenues() {
        try{
            return ResponseEntity.status(200).body(venueService.getAllVenues());
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<VenueCreateRequestDTO> getVenueById(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(venueService.getVenueById(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenue(@RequestParam Long id) {
        try{
            return ResponseEntity.status(200).body(venueService.deleteVenue(id));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> updateVenue(@RequestParam Long id, @RequestBody VenueCreateRequestDTO venueCreateRequestDTO) {
        try{
            return ResponseEntity.status(200).body(venueService.updateVenue(id, venueCreateRequestDTO));
        }catch (Exception e){
            return ResponseEntity.status(400).body(null);
        }
    }
}
