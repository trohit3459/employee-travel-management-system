package com.mindgate.main.repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.main.pojo.BookingDetails;
import com.mindgate.main.pojo.EmployeeDetails;
import com.mindgate.main.pojo.TravelAgentDetails;
import com.mindgate.main.pojo.TravelRequestDetails;
import com.mindgate.main.rowmapper.BookingDetailsRowMapper;

@Repository
public class BookingDetailsRepository implements BookingDetailsRepositoryInterface {
	
	@Autowired
	private BookingDetailsRowMapper bookingDetailsRowMapper;
	
	@Autowired
	private TravelRequestDetails travelRequestDetails;
	
	 @Autowired
	 private TravelAgentDetails travelAgentDetails; 
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	private int result;
	

//	private static final String UPDATE_EMPLOYEE_DETAILS_BY_EMPLOYEE_ID = "UPDATE EMPLOYEE_DETAILS SET LOGIN_ID=?,EMPLOYEE_NAME=?,ADDRESS=?"
//			+ ",DATE_OF_BIRTH=?,CONTACT_NO=?,EMAIL=?,DATE_OF_JOINING=?,MANAGER_NO=?,DESIGNATION=?  WHERE EMPLOYEE_ID=?)";
//	private static final String DELETE_EMPLOYEE_DETAILS_BY_ID = "DELETE FROM EMPLOYEE_DETAILS WHERE EMPLOYEE_ID=?";
	private static final String GET_BOOKING_DETAILS_BY_ID = "SELECT * FROM BOOKING_DETAILS WHERE BOOKING_ID=?";
	private static final String GET_ALL_BOOKING_DETAILS = "SELECT * FROM booking_details";
	private static final String INSERT_BOOKING_DETAILS = "INSERT INTO BOOKING_DETAILS(BOOKING_ID,TRAVEL_REQUEST_ID,AGENT_ID,TRAVELLING_START_DATE"
			+ ",TRAVELLING_END_DATE,STAYS_IN,TRAVEL_MODE,DESTINATION_FROM,DESTINATION_TO,ADDRESS) VALUES (SEQ_BOOKING_DETAILS.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_DETAILS_BY_EMPLOYEE_ID = "select * from booking_details where travel_request_id in(select travel_request_id from Travel_request where employee_id = ?)";

	

//	@Override
//	public boolean updateBookingDetails(BookingDetails bookingDetails) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean deleteBookingDetailsById(int bookingId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public BookingDetails getBookingDetailsById(int bookingId) {
		
		return jdbcTemplate.queryForObject(GET_BOOKING_DETAILS_BY_ID, bookingDetailsRowMapper, new Object[] {bookingId});
		
	}

	@Override
	public List<BookingDetails> getAllBookingDetails() {

		return jdbcTemplate.query(GET_ALL_BOOKING_DETAILS, bookingDetailsRowMapper);
	}
	
	@Override
	public boolean addBookingDetails(BookingDetails bookingDetails) {
		System.out.println("in repo");
		System.out.println(bookingDetails);
		result = jdbcTemplate.update(INSERT_BOOKING_DETAILS, new Object[] {bookingDetails.getTravelRequest().getTravelRequestId(),bookingDetails.getTravelAgentDetails().getAgentId(),bookingDetails.getStartDate(),bookingDetails.getEndDate(),bookingDetails.getStaysIn(),bookingDetails.getTravelMode(),bookingDetails.getDestinationFrom(),bookingDetails.getDestinationTo(),bookingDetails.getAddress()});
		if(result > 0)
			return true;
		return false;
	}
	
	@Override
	public List<BookingDetails> getAllBookingDetailsByEmployeId(int employeeId) {
		
		return jdbcTemplate.query(GET_ALL_DETAILS_BY_EMPLOYEE_ID, bookingDetailsRowMapper, new Object[] {employeeId});
	}



}
