package com.dvb.skip_sp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {


	private static final long serialVersionUID = -6802446081538672753L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "EMAIL", length = 80, nullable = false)
	private String email;

	@Column(name = "NAME", length = 80, nullable = false)
	private String name;

	@Column(name = "ADDRESS", length = 255, nullable = false)
	private String address;

	@Column(name = "CREATION")
	private LocalDateTime creation;

	@Column(name = "PASSWORD", length = 15, nullable = false)
	private String password;

	public Customer() {
		super();
	}

	public Customer(String email, String name, String address, String password) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.password = password;
		this.creation = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", name=" + name + ", address=" + address + ", creation="
				+ creation + ", password=" + password + "]";
	}

}
