package org.rgCorporation.main.model;



import java.time.LocalDate;


public class TravellingRequestDetails {
	
	 private int travelRequestId;
	 private LocalDate travelDepartureDate;
	 private LocalDate travelReturnDate;
	 private String travelReason;
	 private String travelMode;
	 private String tarvelStatus;
	 private String projectManagerStatus;
	 private String directorStatus;
	 private String travelLocation;
	 
	 EmployeeDetails employeeDetails;
	 TravelDetails travelDetails;
	TravelDocumentDetails travelDocumentDetails;
	public TravellingRequestDetails() {
		// TODO Auto-generated constructor stub
	}
	public TravellingRequestDetails(int travelRequestId, LocalDate travelDepartureDate, LocalDate travelReturnDate,
			String travelReason, String travelMode, String tarvelStatus, String projectManagerStatus,
			String directorStatus, String travelLocation, EmployeeDetails employeeDetails, TravelDetails travelDetails,
			TravelDocumentDetails travelDocumentDetails) {
		super();
		this.travelRequestId = travelRequestId;
		this.travelDepartureDate = travelDepartureDate;
		this.travelReturnDate = travelReturnDate;
		this.travelReason = travelReason;
		this.travelMode = travelMode;
		this.tarvelStatus = tarvelStatus;
		this.projectManagerStatus = projectManagerStatus;
		this.directorStatus = directorStatus;
		this.travelLocation = travelLocation;
		this.employeeDetails = employeeDetails;
		this.travelDetails = travelDetails;
		this.travelDocumentDetails = travelDocumentDetails;
	}
	public int getTravelRequestId() {
		return travelRequestId;
	}
	public void setTravelRequestId(int travelRequestId) {
		this.travelRequestId = travelRequestId;
	}
	public LocalDate getTravelDepartureDate() {
		return travelDepartureDate;
	}
	public void setTravelDepartureDate(LocalDate travelDepartureDate) {
		this.travelDepartureDate = travelDepartureDate;
	}
	public LocalDate getTravelReturnDate() {
		return travelReturnDate;
	}
	public void setTravelReturnDate(LocalDate travelReturnDate) {
		this.travelReturnDate = travelReturnDate;
	}
	public String getTravelReason() {
		return travelReason;
	}
	public void setTravelReason(String travelReason) {
		this.travelReason = travelReason;
	}
	public String getTravelMode() {
		return travelMode;
	}
	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}
	public String getTarvelStatus() {
		return tarvelStatus;
	}
	public void setTarvelStatus(String tarvelStatus) {
		this.tarvelStatus = tarvelStatus;
	}
	public String getProjectManagerStatus() {
		return projectManagerStatus;
	}
	public void setProjectManagerStatus(String projectManagerStatus) {
		this.projectManagerStatus = projectManagerStatus;
	}
	public String getDirectorStatus() {
		return directorStatus;
	}
	public void setDirectorStatus(String directorStatus) {
		this.directorStatus = directorStatus;
	}
	public String getTravelLocation() {
		return travelLocation;
	}
	public void setTravelLocation(String travelLocation) {
		this.travelLocation = travelLocation;
	}
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public TravelDetails getTravelDetails() {
		return travelDetails;
	}
	public void setTravelDetails(TravelDetails travelDetails) {
		this.travelDetails = travelDetails;
	}
	public TravelDocumentDetails getTravelDocumentDetails() {
		return travelDocumentDetails;
	}
	public void setTravelDocumentDetails(TravelDocumentDetails travelDocumentDetails) {
		this.travelDocumentDetails = travelDocumentDetails;
	}
	@Override
	public String toString() {
		return "TravellingRequestDetails [travelRequestId=" + travelRequestId + ", travelDepartureDate="
				+ travelDepartureDate + ", travelReturnDate=" + travelReturnDate + ", travelReason=" + travelReason
				+ ", travelMode=" + travelMode + ", tarvelStatus=" + tarvelStatus + ", projectManagerStatus="
				+ projectManagerStatus + ", directorStatus=" + directorStatus + ", travelLocation=" + travelLocation
				+ ", employeeDetails=" + employeeDetails + ", travelDetails=" + travelDetails
				+ ", travelDocumentDetails=" + travelDocumentDetails + "]";
	}
	

}
