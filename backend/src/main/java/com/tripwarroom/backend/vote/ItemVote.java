package com.tripwarroom.backend.vote;

import com.tripwarroom.backend.itinerary.ItineraryItem;
import com.tripwarroom.backend.user.User;
import com.tripwarroom.backend.venue.VenueMetadata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "item_votes",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"itinerary_item_id", "user_id"})
    }
)
public class ItemVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itinerary_item_id", nullable = false)
    private ItineraryItem itineraryItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "choice_venue_id", nullable = false)
    private VenueMetadata choiceVenue;

    @Column(name = "cast_at", nullable = false, updatable = false)
    private LocalDateTime castAt;

    public ItemVote() {
    }

    @PrePersist
    protected void onCreate() {
        if (castAt == null) {
            castAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public ItineraryItem getItineraryItem() {
        return itineraryItem;
    }

    public void setItineraryItem(ItineraryItem itineraryItem) {
        this.itineraryItem = itineraryItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VenueMetadata getChoiceVenue() {
        return choiceVenue;
    }

    public void setChoiceVenue(VenueMetadata choiceVenue) {
        this.choiceVenue = choiceVenue;
    }

    public LocalDateTime getCastAt() {
        return castAt;
    }
}