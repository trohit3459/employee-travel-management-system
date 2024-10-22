package org.rgCorporation.main.model;

import java.time.LocalDate;

public class TravelDetails {
	private int travelDetailsId;
	private String hotelName;
	private String hotelAddress;
	private String hotelBookingStatus;
	private LocalDate travelDepartureDate;
	private  LocalDate travelReturnDate;
	private String ticketBookingStatus;
	private int accommodation;
	public TravelDetails() {
		// TODO Auto-generated constructor stub
	}
	public TravelDetails(int travelDetailsId, String hotelName, String hotelAddress, String hotelBookingStatus,
			LocalDate travelDepartureDate, LocalDate travelReturnDate, String ticketBookingStatus, int accommodation) {
		super();
		this.travelDetailsId = travelDetailsId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.hotelBookingStatus = hotelBookingStatus;
		this.travelDepartureDate = travelDepartureDate;
		this.travelReturnDate = travelReturnDate;
		this.ticketBookingStatus = ticketBookingStatus;
		this.accommodation = accommodation;
	}
	public int getTravelDetailsId() {
		return travelDetailsId;
	}
	public void setTravelDetailsId(int travelDetailsId) {
		this.travelDetailsId = travelDetailsId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelBookingStatus() {
		return hotelBookingStatus;
	}
	public void setHotelBookingStatus(String hotelBookingStatus) {
		this.hotelBookingStatus = hotelBookingStatus;
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
	public String getTicketBookingStatus() {
		return ticketBookingStatus;
	}
	public void setTicketBookingStatus(String ticketBookingStatus) {
		this.ticketBookingStatus = ticketBookingStatus;
	}
	public int getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(int accommodation) {
		this.accommodation = accommodation;
	}
	@Override
	public String toString() {
		return "TravelDetails [travelDetailsId=" + travelDetailsId + ", hotelName=" + hotelName + ", hotelAddress="
				+ hotelAddress + ", hotelBookingStatus=" + hotelBookingStatus + ", travelDepartureDate="
				+ travelDepartureDate + ", travelReturnDate=" + travelReturnDate + ", ticketBookingStatus="
				+ ticketBookingStatus + ", accommodation=" + accommodation + "]";
	}
	

	
	

}
