package com.xcesys.extras.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User{
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = true)
	private String fullname;
	@Column(nullable = true)
	private String mobile;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
