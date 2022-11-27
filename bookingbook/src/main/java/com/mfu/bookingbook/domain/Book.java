package com.mfu.bookingbook.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="BOOK_ID")
	private Long id;

	@Column(name="TITLE")
	private String title;

	@Column(name="IMAGE")
	private String image;
	
	@Column(name="DISCRIPTION")
	private String discription;
	
	// @Column(name="ISBOOKED")
	// private boolean isBooked;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="bookingBook")
    private Set<Booking> bookingIn;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private Author author;
	
	public Book() {}

	public Book(Long id, String title, String discription ,String image) {
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.image = image;
		
	}
	
	public Book(String title, String discription,String image) {
		this(null,title,discription,image);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<Booking> getBookingIn() {
		return bookingIn;
	}

	public void bookingBook(Booking booking) {
		bookingIn.add(booking);
	}
}