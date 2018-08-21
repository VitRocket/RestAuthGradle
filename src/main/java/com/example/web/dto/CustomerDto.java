package com.example.web.dto;

/**
 * Created by Vitalii on 21.08.18.
 */
public class CustomerDto {

	private String id;
	private String firstName;
	private String lastName;

	public CustomerDto() {
	}

	public CustomerDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomerDto(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "CustomerDto{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
