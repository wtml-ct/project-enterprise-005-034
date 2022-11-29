package com.mfu.bookingbook.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AUTHOR")
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="AUTHOR_ID")
	private Long id;

	@Column(name="NAME")
	private String name;

	@Column(name="PIC")
	private String pic;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private Set<Book> book;

	public Author() {}

	public Author(Long id, String name, String pic) {
		this.id = id;
		this.name = name;
		this.pic = pic;
	}
	
	public Author(String name,String pic) {
		this(null,name,pic);
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
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
	public Set<Book> getBook() {
		return book;
	}
	
	public void setBook(Set<Book> book) {
		this.book = book;
	}
}