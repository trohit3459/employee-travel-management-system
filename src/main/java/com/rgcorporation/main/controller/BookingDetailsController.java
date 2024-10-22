package com.rgcorporation.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgcorporation.main.model.BookingDetails;
import com.rgcorporation.main.service.BookingDetailsServiceInterface;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("bookingDetails")
public class BookingDetailsController {
	
	@Autowired
	private BookingDetailsServiceInterface bookingDetailsService;
	
	
	@RequestMapping(value = "booking/{id}", method = RequestMethod.GET)
	public @ResponseBody BookingDetails getBookingDetailsById(@PathVariable("id") int bookingId) {

		System.out.println("in Booking Service Byid");
		return bookingDetailsService.getBookingDetailsById(bookingId);

	}

	@RequestMapping(value = "booking", method = RequestMethod.GET)
	public @ResponseBody List<BookingDetails> getAllBookingDetails() {
		return bookingDetailsService.getAllBookingDetails();
	}
	
	
	@RequestMapping(value = "addbookingdetails", method = RequestMethod.POST)
	public @ResponseBody boolean addBookingDetails(@RequestBody BookingDetails bookingDetails) {
		System.out.println("in booking controller");
		System.out.println(bookingDetails);
		return bookingDetailsService.addBookingDetails(bookingDetails);
	}
	
	@RequestMapping(value = "detailsbyemployeeid/{employeeId}" , method = RequestMethod.GET)
	public @ResponseBody List<BookingDetails> getAllBookingDetailsByEmployeId(@PathVariable int employeeId){
		return bookingDetailsService.getAllBookingDetailsByEmployeId(employeeId);
	}

}
