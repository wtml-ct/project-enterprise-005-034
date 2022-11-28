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

	@Column(name="DATE")
	private String date;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID")
	private Book bookingBook;

	public Booking(){}
	
	public Booking(Long id, String date){
		this.id = id;
		
		this.date = date;
	}
	
	public Booking(String date){
		this(null, date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public Book getBookingBook() {
		return bookingBook;
	}
}