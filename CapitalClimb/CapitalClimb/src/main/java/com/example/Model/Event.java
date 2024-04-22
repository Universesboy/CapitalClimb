package com.example.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "events")

public class Event {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column (nullable = false)
private String name;

@Column (length = 1000)
private String description;

private String location;

@Column(name ="event_date")
private LocalDateTime eventDate;

@CreationTimestamp
@Column(name = "created_at", updatable = false)
private LocalDateTime createdAt;

@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;

//Many to one relationship:an event can be created by one user
@ManyToOne (fetch = FetchType.LAZY)
@JoinColumn(name = "organizer_id")
private User organizer;

//Many to many relationship: an event can have multiple participants
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
		name = "event_participants",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id"))
private Set<User> participants;

//Getters and Setters
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public LocalDateTime getEventDate() {
	return eventDate;
}

public void setEventDate(LocalDateTime eventDate) {
	this.eventDate = eventDate;
}

public LocalDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

public LocalDateTime getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
}

public User getOrganizer() {
	return organizer;
}

public void setOrganizer(User organizer) {
	this.organizer = organizer;
}

public Set<User> getParticipants() {
	return participants;
}

public void setParticipants(Set<User> participants) {
	this.participants = participants;
}

}
