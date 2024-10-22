  package org.rgCorporation.main.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import org.rgCorporation.main.model.TravelDetails;



public class TravelDetailsRowMapper implements RowMapper<TravelDetails> {

	@Override
	public TravelDetails mapRow(ResultSet resultSet, int i) throws SQLException {
	 int travelDetailsId=resultSet.getInt("TRAVEL_DETAILS_ID");
      String hotelName=resultSet.getString("HOTEL_NAME");
     String hotelAddress=resultSet.getString("HOTEL_ADDRESS");
		 String hotelBookingStatus=resultSet.getString("HOTEL_BOOKING_STATUS");
		 LocalDate travelDepartureDate=resultSet.getDate("TRAVEL_DEPARTURE_DATE").toLocalDate();
		  LocalDate travelReturnDate=resultSet.getDate("TRAVEL_RETURN_DATE").toLocalDate();
		 String ticketBookingStatus=resultSet.getString("TICKET_BOOKING_STATUS");
		int accommodation=resultSet.getInt("ACCOMODATION_COST");
		TravelDetails travelDetails=new TravelDetails(travelDetailsId, hotelName, hotelAddress, hotelBookingStatus, travelDepartureDate, travelReturnDate, ticketBookingStatus, accommodation);
		return travelDetails;
	}

}

