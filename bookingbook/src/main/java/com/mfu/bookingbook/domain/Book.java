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
	
	@Column(name="DESCRIPTION")
	private String description;
	
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
	
	public Book(Long id, String title, String description ,String image) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		
	}
	
	public Book(String title, String description,String image) {
		this(null,title,description,image);
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

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	// public Set<Booking> getBookingIn() {
		// 	return bookingIn;
		// }
		
		// public void bookingBook(Booking booking) {
			// 	bookingIn.add(booking);
			// }
}