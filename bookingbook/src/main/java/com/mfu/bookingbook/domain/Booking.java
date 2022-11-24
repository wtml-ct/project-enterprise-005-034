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

	@Column(name="DATE")
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToMany
    @JoinTable(
            name = "BOOKING_BOOK",
            joinColumns = @JoinColumn(name = "BOOKING_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> bookingBooks = new HashSet<>();
	
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
	
	public Set<Book> getBookingBooks() {
		return bookingBooks;
	}
}