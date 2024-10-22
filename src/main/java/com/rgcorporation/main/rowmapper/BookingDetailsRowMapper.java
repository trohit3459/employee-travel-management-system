package com.rgcorporation.main.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rgcorporation.main.model.BookingDetails;
import com.rgcorporation.main.model.TravelAgentDetails;
import com.rgcorporation.main.model.TravelRequestDetails;
import com.rgcorporation.main.repository.TravelAgentDetailsRepository;
import com.rgcorporation.main.repository.TravelRequestDetailsRepository;
@Component
public final class BookingDetailsRowMapper implements RowMapper<BookingDetails> {
		
		@Autowired
		private TravelRequestDetailsRepository requestDetailsRepository;
		@Autowired
		private TravelAgentDetailsRepository travelAgentDetailsRepository;
		
		@Override
		public BookingDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
			System.out.println("in booking maprow");
			int bookingId =resultSet.getInt("BOOKING_ID");
			int travelRequestId= resultSet.getInt("Travel_request_id");
			int agentId = resultSet.getInt("AGENT_ID");
			Date startDate = resultSet.getDate("TRAVELLING_START_DATE");
			System.out.println(startDate);
			LocalDate newTravellingStartDate = startDate.toLocalDate();
			Date endDate = resultSet.getDate("TRAVELLING_END_DATE");
			System.out.println("end date"+endDate);
			LocalDate newTravellingEndDate = endDate.toLocalDate();
			String staysIn = resultSet.getString("STAYS_IN");
			String travelMode = resultSet.getString("TRAVEL_MODE");
			String destinationFrom = resultSet.getString("DESTINATION_FROM");
			String destinationTo = resultSet.getString("DESTINATION_TO");
			String address = resultSet.getString("ADDRESS");
			TravelRequestDetails travelRequestDetails = requestDetailsRepository.getSingleRequestByRequestId(travelRequestId);
			TravelAgentDetails travelAgentDetails = travelAgentDetailsRepository.getTravelAgentByAgentId(agentId);
			
			BookingDetails bookingDetails = new BookingDetails();
			
			bookingDetails.setBookingId(bookingId);
			bookingDetails.setTravelRequest(travelRequestDetails);
			bookingDetails.setTravelAgentDetails(travelAgentDetails);
			bookingDetails.setStartDate(newTravellingStartDate);
			bookingDetails.setEndDate(newTravellingEndDate);
			bookingDetails.setStaysIn(staysIn);
			bookingDetails.setTravelMode(travelMode);
			bookingDetails.setDestinationFrom(destinationFrom);
			bookingDetails.setDestinationTo(destinationTo);
			bookingDetails.setAddress(address);
			
			return bookingDetails;
		}
		}	
