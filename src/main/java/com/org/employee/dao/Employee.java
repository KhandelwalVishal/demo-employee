package com.org.employee.dao;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;

	@NotEmpty(message = "First name is required")
	private String empName;

	@NotEmpty(message = "Address is required")
	private String address;

	@NotEmpty(message = "Date of Birth is required")
	private String dateOfBirth;

	@NotEmpty(message = "Contact Number is required")
	private String contactNumber;

	@NotEmpty(message = "Title is required")
	private String title;

	@NotEmpty(message = "SIN number is required")
	@Size(min = 4, message = "SIN number should have at least 4 characters")
	@Column(unique = true)
	private String sin;	

	public Employee() {
		super();
	}

	public Employee(long empId, @NotEmpty(message = "First name is required") String empName,
			@NotEmpty(message = "Address is required") String address,
			@NotEmpty(message = "Date of Birth is required") String dateOfBirth,
			@NotEmpty(message = "Contact Number is required") String contactNumber,
			@NotEmpty(message = "Title is required") String title,
			@NotEmpty(message = "SIN number is required") @Size(min = 4, message = "SIN number should have at least 4 characters") String sin) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.title = title;
		this.sin = sin;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, contactNumber, dateOfBirth, empId, empName, sin, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(contactNumber, other.contactNumber)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && empId == other.empId
				&& Objects.equals(empName, other.empName) && Objects.equals(sin, other.sin)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", dateOfBirth="
				+ dateOfBirth + ", contactNumber=" + contactNumber + ", title=" + title + ", sin=" + sin + "]";
	}

}
