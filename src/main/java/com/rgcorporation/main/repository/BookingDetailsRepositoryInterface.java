package com.rgcorporation.main.repository;

import java.util.List;

import com.rgcorporation.main.model.BookingDetails;

public interface BookingDetailsRepositoryInterface {
	
	 
//     public boolean updateBookingDetails(BookingDetails bookingDetails);
//    public boolean deleteBookingDetailsById(int bookingId);
     public BookingDetails getBookingDetailsById(int bookingId);
     public List<BookingDetails> getAllBookingDetails();
     public boolean addBookingDetails(BookingDetails bookingDetails);
     public List<BookingDetails> getAllBookingDetailsByEmployeId(int employeeId);

}