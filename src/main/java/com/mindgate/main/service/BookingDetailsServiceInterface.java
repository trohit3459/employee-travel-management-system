package com.mindgate.main.service;

import java.util.List;

import com.mindgate.main.pojo.BookingDetails;
import com.mindgate.main.pojo.LoginDetails;

public interface BookingDetailsServiceInterface {

//     public boolean updateBookingDetails(BookingDetails bookingDetails);
//     public boolean deleteBookingDetailsById(int bookingId);
     public BookingDetails getBookingDetailsById(int bookingId);
     public List<BookingDetails> getAllBookingDetails();
     public boolean addBookingDetails(BookingDetails bookingDetails);
     public List<BookingDetails> getAllBookingDetailsByEmployeId(int employeeId);
}

