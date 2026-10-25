package com.tripwarroom.backend.itinerary;

import com.tripwarroom.backend.trip.Trip;
import com.tripwarroom.backend.user.User;
import com.tripwarroom.backend.venue.VenueMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(
    name = "itinerary_items",
    indexes = {
        @Index(
            name = "idx_itinerary_trip_day",
            columnList = "trip_id, day_index"
        )
    }
)
public class ItineraryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "venue_id", nullable = false)
    private VenueMetadata venue;

    @Column(name = "day_index", nullable = false)
    private Integer dayIndex;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "lifecycle_stage", nullable = false, length = 20)
    private String lifecycleStage = "drafting";

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pinned_by_user_id", nullable = false)
    private User pinnedBy;

    @Column(name = "position_version", nullable = false)
    private Integer positionVersion = 0;

    public ItineraryItem() {
    }

    public Long getId() {
        return id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public VenueMetadata getVenue() {
        return venue;
    }

    public void setVenue(VenueMetadata venue) {
        this.venue = venue;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLifecycleStage() {
        return lifecycleStage;
    }

    public void setLifecycleStage(String lifecycleStage) {
        this.lifecycleStage = lifecycleStage;
    }

    public User getPinnedBy() {
        return pinnedBy;
    }

    public void setPinnedBy(User pinnedBy) {
        this.pinnedBy = pinnedBy;
    }

    public Integer getPositionVersion() {
        return positionVersion;
    }

    public void setPositionVersion(Integer positionVersion) {
        this.positionVersion = positionVersion;
    }
}