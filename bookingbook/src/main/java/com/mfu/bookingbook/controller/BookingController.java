package com.mfu.bookingbook.controller;

import com.mfu.bookingbook.repository.*;
import com.mfu.bookingbook.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {
  
  @Autowired
  private BookingRepository bookingRepo;
  
  @GetMapping("/getAllBookings")
  public ResponseEntity<List<Booking>> getAllBookings() {
	  try {
		  List<Booking> bookingList = new ArrayList<>();
		  bookingRepo.findAll().forEach(bookingList::add);
		  
		  if(bookingList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(bookingList, HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
  }
  
  @GetMapping("/getBookingById/{id}")
  public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
	  Optional<Booking> bookingData = bookingRepo.findById(id);
	  
	  if(bookingData.isPresent()) {
		  return new ResponseEntity<>(bookingData.get(), HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @PostMapping("/addBooking")
  public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
	  Booking bookingObj = bookingRepo.save(booking);
	  
	  return new ResponseEntity<>(bookingObj, HttpStatus.OK);
  }
  
  @PostMapping("/updateBookingById/{id}")
  public ResponseEntity<Booking> updateBookingById(@PathVariable Long id, @RequestBody Booking newBookingData) {
	  Optional<Booking> oldBookingData = bookingRepo.findById(id);
	  
	  if(oldBookingData.isPresent()) {
		  Booking updatedBookingData = oldBookingData.get();
		  updatedBookingData.setAmount(newBookingData.getAmount());
		  updatedBookingData.setDate(newBookingData.getDate());
		  
		  Booking bookingObj = bookingRepo.save(updatedBookingData);
		  return new ResponseEntity<>(bookingObj, HttpStatus.OK);
	  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
  
  @DeleteMapping("/deleteBookingById/{id}")
  public ResponseEntity<HttpStatus> deleteBookingById(@PathVariable Long id) {
	  bookingRepo.deleteById(id);
	  return new ResponseEntity<>(HttpStatus.OK);
  }
}