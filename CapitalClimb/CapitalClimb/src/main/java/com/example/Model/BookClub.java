package com.example.Model;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_club")
public class BookClub {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;

@Column(length = 1000)
private String description;

@CreationTimestamp
@Column(name = "created_at", updatable = false, nullable = false)
private LocalDateTime createdAt;

@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;

//Many to one relationship: users who are members of the book club
@ManyToOne(fetch = FetchType.LAZY)
@JoinTable(
        name = "book_club_members",
        joinColumns = @JoinColumn(name = "book_club_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
private Set<User> members;

//one to many relationship: a book club can have multiple books and books discussed in the book club
@OneToMany(mappedBy = "bookClub", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
private Set<Book> books = new HashSet<>();

//Constructors, Getters, and Setters
public BookClub() {}

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

public LocalDateTime getCreatedAt() {
			return createdAt;
}

public LocalDateTime getUpdatedAt() {
	return updatedAt;
}

public Set<User> getMembers() {
	return members;
}

public void setMembers(Set<User> members) {
	this.members = members;
}

public Set<Book> getBooks() {
	return books;
}

public void setBooks(Set<Book> books) {
	this.books = books;
}

		


}
