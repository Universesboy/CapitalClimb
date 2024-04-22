package com.example.Model;
import java.math.BigDecimal;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_marketplace")
public class Transaction_Marketplace {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "buyer_id", nullable = false)
private User buyer;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "seller_id", nullable = false)
private User seller;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "product_id", nullable = false)
private Product product;

@Column(nullable = false)
private BigDecimal amount;  // This could represent the total transaction amount.

@CreationTimestamp
@Column(name = "transaction_date", nullable = false)
private LocalDateTime transactionDate;  // When the transaction occurred.

@UpdateTimestamp
@Column(name = "updated_at")
private LocalDateTime updatedAt;

// Getters and setters
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public User getBuyer() {
	return buyer;
}

public void setBuyer(User buyer) {
	this.buyer = buyer;
}

public User getSeller() {
	return seller;
}

public void setSeller(User seller) {
	this.seller = seller;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public LocalDateTime getTransactionDate() {
	return transactionDate;
}

public void setTransactionDate(LocalDateTime transactionDate) {
	this.transactionDate = transactionDate;
}

public LocalDateTime getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
}

}
