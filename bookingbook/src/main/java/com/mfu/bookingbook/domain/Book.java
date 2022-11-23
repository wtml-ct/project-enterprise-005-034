package com.mfu.bookingbook.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private Long id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DISCRIPTION")
	private String discription;
	
	@Column(name="ISBOOKED")
	private boolean isBooked;
	
	@ManyToMany(mappedBy = "bookBooks")
	private Set<Booking> bookingIn = new HashSet<>();
	 
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	public Book() {}

	public Book(Long id, String name, String discription , boolean isBooked) {
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.isBooked = isBooked;
	}
	
	public Book(String name, String discription, boolean isBooked) {
		this(null,name,discription,isBooked);
	}

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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	public Set<Booking> getBookingIn() {
		return bookingIn;
	}

	public void bookingBook(Booking booking) {
		bookingIn.add(booking);
	}
}