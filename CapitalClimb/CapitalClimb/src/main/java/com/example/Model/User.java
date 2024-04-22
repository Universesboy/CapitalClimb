package com.example.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false, unique = true)
private String username;

@Column(nullable = false, unique = true)
private String email;

@Column(nullable = false)
private String password;

@Column(name = "profile_picture")
private String profilePicture;

@CreationTimestamp
@Column(name = "created_at", nullable = false, updatable = false)
private LocalDateTime createdAt;

@UpdateTimestamp	
@Column(name = "updated_at")
private LocalDateTime updatedAt;

//onetomany with post
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
private Set<Post> posts = new HashSet<>();

//manytomany with event
@ManyToMany(mappedBy = "participants", fetch = FetchType.LAZY)
private Set<Event> events = new HashSet<>();

//manytomany with investment
@ManyToMany(mappedBy = "investors", fetch = FetchType.LAZY)
private Set<Investment> investments = new HashSet<>();

//manytomany with bookclub (members)
@ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
private Set<BookClub> bookClubs = new HashSet<>();

//constructors, Getters and Setters
public User() {}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getProfilePicture() {
	return profilePicture;
}

public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
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

public Set<Post> getPosts() {
	return posts;
}

public void setPosts(Set<Post> posts) {
	this.posts = posts;
}

public Set<Event> getEvents() {
	return events;
}

public void setEvents(Set<Event> events) {
	this.events = events;
}

public Set<Investment> getInvestments() {
	return investments;
}

public void setInvestments(Set<Investment> investments) {
	this.investments = investments;
}

public Set<BookClub> getBookClubs() {
	return bookClubs;
}

public void setBookClubs(Set<BookClub> bookClubs) {
	this.bookClubs = bookClubs;
}

}
