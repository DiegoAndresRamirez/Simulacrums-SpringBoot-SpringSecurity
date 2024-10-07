package com.events.riwi.domain.persistence;

import com.events.riwi.domain.models.VenueOrganizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueOrganizatorRepository extends JpaRepository<VenueOrganizator, Long> {
}
