package com.mfu.bookingbook.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="BOOKING_ID")
	private Long id;
	
	@Column(name="AMOUNT")
	private String amount;

	@Column(name="DATE_BOOK")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID")
	private Book bookingBook;

	public Booking(){}
	
	public Booking(Long id, String amount,  LocalDateTime date){
		this.id = id;
		this.amount = amount;
		this.date = date;
	}
	
	public Booking(String amount,  LocalDateTime date){
		this(null,amount, date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBookingBook(Book bookingBook) {
		this.bookingBook = bookingBook;
	}
}