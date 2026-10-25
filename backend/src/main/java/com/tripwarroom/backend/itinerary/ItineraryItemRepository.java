package com.tripwarroom.backend.itinerary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryItemRepository
        extends JpaRepository<ItineraryItem, Long> {
}