package com.tripwarroom.backend.user;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, unique = true ,length = 255)
    private String email;
    @Column (name = "display_name", nullable = false, length = 100)
    private String displayName;
    @Column (name = "password_hash", nullable = false, length = 255)
    private String passwordHash;
    @Column (nullable = false, length = 20)
    private String role;
    @Column(name = "budget_ceiling", precision = 10, scale = 2)
    private BigDecimal budgetCeiling;
    @ElementCollection 
    @CollectionTable (name = "user_dietary_tags", joinColumns = @JoinColumn(name = "user_id"))
    private Set<String> dietaryTags = new HashSet<>();
    @Column (name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public User() {
       
    }

    @PrePersist 
    protected void onCreate() {
        if (createdAt == null) {
        createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public BigDecimal getBudgetCeiling() {
        return budgetCeiling;
    }
    public void setBudgetCeiling(BigDecimal budgetCeiling) {
        this.budgetCeiling = budgetCeiling;
    }
    public Set<String> getDietaryTags() {
        return dietaryTags;
    }
    public void setDietaryTags(Set<String> dietaryTags) {
        this.dietaryTags = dietaryTags;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
