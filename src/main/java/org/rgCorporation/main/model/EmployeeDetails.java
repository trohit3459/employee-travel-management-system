package org.rgCorporation.main.model;

public class EmployeeDetails {

	private int employeeDetailsId;
	private String firstName;
	private String lastName;
	private String address;
	private int managerId;
	private String city;
	private String state;
	private String emailId;
	private String contactNo;
	private String designation;
	private LoginDetails loginDetails;

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDetails(int employeeDetailsId, String firstName, String lastName, String address, int managerId,
			String city, String state, String emailId, String contactNo, String designation,
			LoginDetails loginDetails) {
		super();
		this.employeeDetailsId = employeeDetailsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.managerId = managerId;
		this.city = city;
		this.state = state;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.designation = designation;
		this.loginDetails = loginDetails;
	}

	public int getEmployeeDetailsId() {
		return employeeDetailsId;
	}

	public void setEmployeeDetailsId(int employeeDetailsId) {
		this.employeeDetailsId = employeeDetailsId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeDetailsId=" + employeeDetailsId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", managerId=" + managerId + ", city=" + city + ", state=" + state
				+ ", emailId=" + emailId + ", contactNo=" + contactNo + ", designation=" + designation
				+ ", loginDetails=" + loginDetails + "]";
	}

}
