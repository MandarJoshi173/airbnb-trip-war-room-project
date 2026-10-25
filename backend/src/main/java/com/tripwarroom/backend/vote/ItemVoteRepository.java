package com.tripwarroom.backend.vote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVoteRepository extends JpaRepository<ItemVote, Long> {
}