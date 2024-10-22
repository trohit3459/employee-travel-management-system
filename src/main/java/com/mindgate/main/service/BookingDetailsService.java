package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindgate.main.pojo.BookingDetails;
import com.mindgate.main.repository.BookingDetailsRepositoryInterface;
import com.mindgate.main.repository.LoginDetailsRepositoryInterface;

@Service
public class BookingDetailsService implements BookingDetailsServiceInterface {

	@Autowired
	private BookingDetailsRepositoryInterface bookingDetailsRepositoryInterface;

	
//
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
		// TODO Auto-generated method stub
		return bookingDetailsRepositoryInterface.getBookingDetailsById(bookingId);
	}

	@Override
	public List<BookingDetails> getAllBookingDetails() {
		// TODO Auto-generated method stub
		return bookingDetailsRepositoryInterface.getAllBookingDetails();
	}
	@Override
	public boolean addBookingDetails(BookingDetails bookingDetails) {
		
		return bookingDetailsRepositoryInterface.addBookingDetails(bookingDetails);
	}
	@Override
	public List<BookingDetails> getAllBookingDetailsByEmployeId(int employeeId) {
		
		return bookingDetailsRepositoryInterface.getAllBookingDetailsByEmployeId(employeeId);
	}

}
