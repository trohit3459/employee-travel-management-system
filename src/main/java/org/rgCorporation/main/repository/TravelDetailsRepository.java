package org.rgCorporation.main.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.rgCorporation.main.model.TravelDetails;

@Repository
public class TravelDetailsRepository implements TravelDetailsRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int resultCount;

	private static final String INSERT_TRAVELLING_DETAILS = "INSERT INTO TRAVELLING_DETAILS(TRAVEL_DETAILS_ID,HOTEL_NAME ,HOTEL_ADDRESS,HOTEL_BOOKING_STATUS,TRAVEL_DEPARTURE_DATE ,TRAVEL_RETURN_DATE ,TICKET_BOOKING_STATUS ,ACCOMODATION_COST )VALUES (SEQUE_TRAVELLING_DETAILS.NEXTVAL,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_TRAVELLING_DETAILS = "SELECT * FROM TRAVELLING_DETAILS";
	private static final String SELECT_SINGLE_TRAVELLING_DETAILS = "SELECT * FROM TRAVELLING_DETAILS WHERE TRAVEL_DETAILS_ID = ?";
	private static final String UPDATE_TRAVELLING_DETAILS = "UPDATE TRAVELLING_DETAILS SET HOTEL_NAME=? ,HOTEL_ADDRESS=?,HOTEL_BOOKING_STATUS=?,TRAVEL_DEPARTURE_DATE=? ,TRAVEL_RETURN_DATE=? ,TICKET_BOOKING_STATUS=? ,ACCOMODATION_COST=?  WHERE TRAVEL_DETAILS_ID = ?";

	@Override
	public boolean addTravelDetails(TravelDetails travelDetails) {
		Object[] args = { travelDetails.getHotelName(), travelDetails.getHotelAddress(),
				travelDetails.getHotelBookingStatus(), travelDetails.getTravelDepartureDate(),
				travelDetails.getTravelReturnDate(), travelDetails.getTicketBookingStatus(),
				travelDetails.getAccommodation() };
		resultCount = jdbcTemplate.update(INSERT_TRAVELLING_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateTravelDetailsByTravelDetailsId(TravelDetails travelDetails) {
		Object[] args = { travelDetails.getHotelName(), travelDetails.getHotelAddress(),
				travelDetails.getHotelBookingStatus(), travelDetails.getTravelDepartureDate(),
				travelDetails.getTravelReturnDate(), travelDetails.getTicketBookingStatus(),
				travelDetails.getAccommodation(), travelDetails.getTravelDetailsId() };

		resultCount = jdbcTemplate.update(UPDATE_TRAVELLING_DETAILS, args);
		if (resultCount > 0)
			return true;
		else
			return false;
	}

	@Override
	public TravelDetails getTravelDetailsByTravelDetailsId(int travelDetailsId) {
		Object[] args = { travelDetailsId };
		TravelDetails details = jdbcTemplate.queryForObject(SELECT_SINGLE_TRAVELLING_DETAILS,
				new TravelDetailsRowMapper(), args);
		return details;
	}

	@Override
	public List<TravelDetails> getAllTravelDetails() {
		List<TravelDetails> details = jdbcTemplate.query(SELECT_ALL_TRAVELLING_DETAILS, new TravelDetailsRowMapper());
		return details;
	}

}
