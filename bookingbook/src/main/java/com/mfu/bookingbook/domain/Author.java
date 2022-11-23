package com.mfu.bookingbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="AUTHOR_ID")
	private Long id;

	@Column(name="NAME")
	private String name;
	
	public Author() {}

	public Author(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Author(String name) {
		this(null,name);
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
}