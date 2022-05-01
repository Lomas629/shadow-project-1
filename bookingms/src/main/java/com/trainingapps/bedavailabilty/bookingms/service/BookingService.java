package com.trainingapps.bedavailabilty.bookingms.service;

import com.trainingapps.bedavailabilty.bookingms.constants.BookingStatus;
import com.trainingapps.bedavailabilty.bookingms.dto.*;
import com.trainingapps.bedavailabilty.bookingms.entity.Booking;
import com.trainingapps.bedavailabilty.bookingms.exceptions.BookingNotFoundException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingAmountException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingIdException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingTypeException;
import com.trainingapps.bedavailabilty.bookingms.repository.IBookingRepository;
import com.trainingapps.bedavailabilty.bookingms.util.BookingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class BookingService implements IBookingService{

    @Autowired
    private BookingUtil util;

    @Autowired
    private IBookingRepository repository;

    @Override
    public BookingDetails book(BookingRequest requestData) throws InvalidBookingAmountException, InvalidBookingTypeException {
        //data from request
        Booking booking = new Booking();

        //Convert string to localDatetime
        LocalDateTime bookedDateTime = util.toLocalDateTime(requestData.getBookedDateTime());
        LocalDateTime occupiedDateTime = util.toLocalDateTime( requestData.getOccupiedDateTime());
        BookingStatus bookingStatus = util.toEnum(requestData.getBookingStatus());
        LocalDateTime releaseDate = util.toLocalDateTime(requestData.getReleaseDate());

        booking.setPatientId(requestData.getPatientId());
        booking.setBookingStatus(bookingStatus);
        booking.setBookingAmount(requestData.getBookingAmount());
        booking.setBookedDateTime(bookedDateTime);
        booking.setOccupiedDateTime(occupiedDateTime);
        booking.setReleaseDate(releaseDate);


        //storing object into database
        Booking booking1 = repository.save(booking);

        BookingDetails details = util.toBookingDetails(booking1);

        return details;

    }

    public Booking findById(Long id) throws InvalidBookingIdException {
        Optional<Booking> optional = repository.findById(id);
        if(optional.isPresent() == false){
            throw new InvalidBookingIdException("ID is not present");
        }
        Booking booking = optional.get();
        return booking;
    }

    @Override
    public BookingDetails cancel(UnBookingRequest requestData) throws InvalidBookingIdException, InvalidBookingTypeException {
        Long id = requestData.getId();
        Booking booking = findById(id);
        BookingStatus status = util.toEnum(requestData.getBookingstatus());
        booking.setBookingStatus(status);
        repository.save(booking);
        BookingDetails details = util.toBookingDetails(booking);
        return details;
    }


    @Override
    public BookingDetails update(UpdateBooking booking) throws InvalidBookingIdException, BookingNotFoundException, InvalidBookingTypeException {
        //Get ID from object
        Long id = booking.getId();

        //Convert String to LocalDate
        LocalDateTime bookedDateTime = util.toLocalDateTime(booking.getBookedDateTime());
        LocalDateTime occupiedDateTime = util.toLocalDateTime(booking.getOccupiedDateTime());
        LocalDateTime releaseDate = util.toLocalDateTime(booking.getReleaseDate());

        //find by ID
        Booking booking1 = findById(id);

        //set data in booking object
        booking1.setId(booking.getId());
        booking1.setPatientId(booking.getPatientId());
        booking1.setBookingAmount(booking.getBookingAmount());
        booking1.setBookedDateTime(bookedDateTime);
        booking1.setOccupiedDateTime(occupiedDateTime);
        booking1.setReleaseDate(releaseDate);
        repository.save(booking1);
        BookingDetails details = util.toBookingDetails(booking1);
        return details;
    }

    @Override
    public BookingDetails findByBookingDetailsByPatientId(Long id) {
          Booking booking = repository.findDetailsByPatientId(id);
          BookingDetails details = util.toBookingDetails(booking);
          return details;
    }

    @Override
    public Billdetails billdetailsByBookingId(Long id){
        Billdetails billdetails = new Billdetails();
        BookingDetails details = findByBookingDetailsByPatientId(id);
        billdetails.setBookingAmount(details.getBookingAmount());
        billdetails.setId(details.getId());
        billdetails.setPatientId(details.getPatientId());
        return billdetails;
    }


}
