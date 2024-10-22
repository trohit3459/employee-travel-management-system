package com.mindgate.main.pojo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookingDetails {
	private int bookingId;
	@Autowired
	private TravelRequestDetails travelRequest;
	@Autowired
	private TravelAgentDetails travelAgentDetails;
	private LocalDate startDate;
	private LocalDate endDate;
	private String staysIn;
	private String travelMode;
	private String destinationFrom;
	private String destinationTo;
	private String address;


	public BookingDetails() {
	}


	public BookingDetails(int bookingId, TravelRequestDetails travelRequest, TravelAgentDetails travelAgentDetails,
			LocalDate startDate, LocalDate endDate, String staysIn, String travelMode, String destinationFrom,
			String destinationTo, String address) {
		super();
		this.bookingId = bookingId;
		this.travelRequest = travelRequest;
		this.travelAgentDetails = travelAgentDetails;
		this.startDate = startDate;
		this.endDate = endDate;
		this.staysIn = staysIn;
		this.travelMode = travelMode;
		this.destinationFrom = destinationFrom;
		this.destinationTo = destinationTo;
		this.address = address;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public TravelRequestDetails getTravelRequest() {
		return travelRequest;
	}


	public void setTravelRequest(TravelRequestDetails travelRequest) {
		this.travelRequest = travelRequest;
	}


	public TravelAgentDetails getTravelAgentDetails() {
		return travelAgentDetails;
	}


	public void setTravelAgentDetails(TravelAgentDetails travelAgentDetails) {
		this.travelAgentDetails = travelAgentDetails;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getStaysIn() {
		return staysIn;
	}


	public void setStaysIn(String staysIn) {
		this.staysIn = staysIn;
	}


	public String getTravelMode() {
		return travelMode;
	}


	public void setTravelMode(String travelMode) {
		this.travelMode = travelMode;
	}


	public String getDestinationFrom() {
		return destinationFrom;
	}


	public void setDestinationFrom(String destinationFrom) {
		this.destinationFrom = destinationFrom;
	}


	public String getDestinationTo() {
		return destinationTo;
	}


	public void setDestinationTo(String destinationTo) {
		this.destinationTo = destinationTo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", travelRequest=" + travelRequest + ", travelAgentDetails="
				+ travelAgentDetails + ", startDate=" + startDate + ", endDate=" + endDate + ", staysIn=" + staysIn
				+ ", travelMode=" + travelMode + ", destinationFrom=" + destinationFrom + ", destinationTo="
				+ destinationTo + ", address=" + address + "]";
	}

	
	 	
}