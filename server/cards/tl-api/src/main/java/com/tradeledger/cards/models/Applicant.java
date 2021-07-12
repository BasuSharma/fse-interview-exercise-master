package com.tradeledger.cards.models;

import javax.validation.constraints.NotNull;

public final class Applicant {

	

	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private String email;
	
	public Applicant() {}
	
	public Applicant(String name, String email, String address) {
		
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "Applicant [name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	
}
