package com.tripwarroom.backend.venue;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "venue_metadata",
    indexes = {
        @Index(
            name = "idx_venue_destination_coordinates",
            columnList = "destination, lat, lng"
        )
    }
)
public class VenueMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String destination;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(name = "price_per_person", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerPerson;

    @Column(name = "hours_open", nullable = false)
    private LocalTime hoursOpen;

    @Column(name = "hours_close", nullable = false)
    private LocalTime hoursClose;

    @Column(name = "lat", nullable = false)
    private Double latitude;

    @Column(name = "lng", nullable = false)
    private Double longitude;

    @Column(length = 1000)
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "venue_dietary_tags",
        joinColumns = @JoinColumn(name = "venue_id")
    )
    @Column(name = "tag", nullable = false, length = 40)
    private Set<String> dietaryTags = new HashSet<>();

    public VenueMetadata() {
    }

    public Long getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(BigDecimal pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public LocalTime getHoursOpen() {
        return hoursOpen;
    }

    public void setHoursOpen(LocalTime hoursOpen) {
        this.hoursOpen = hoursOpen;
    }

    public LocalTime getHoursClose() {
        return hoursClose;
    }

    public void setHoursClose(LocalTime hoursClose) {
        this.hoursClose = hoursClose;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getDietaryTags() {
        return dietaryTags;
    }

    public void setDietaryTags(Set<String> dietaryTags) {
        this.dietaryTags = dietaryTags;
    }
}