package com.mfu.bookingbook.domain;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="USER_ID")
	private Long id;

	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	public User() {}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		this(null, username, password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
