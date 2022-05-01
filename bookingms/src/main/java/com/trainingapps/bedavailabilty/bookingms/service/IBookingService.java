package com.trainingapps.bedavailabilty.bookingms.service;

import com.trainingapps.bedavailabilty.bookingms.dto.*;
import com.trainingapps.bedavailabilty.bookingms.exceptions.BookingNotFoundException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingAmountException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingIdException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingTypeException;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Component
public interface IBookingService {
    BookingDetails book(@Valid BookingRequest requestData) throws InvalidBookingAmountException, InvalidBookingTypeException;

    BookingDetails cancel(@Valid UnBookingRequest requestData) throws InvalidBookingIdException, InvalidBookingTypeException;

    BookingDetails update(@Valid UpdateBooking booking) throws InvalidBookingIdException, BookingNotFoundException, InvalidBookingTypeException;

    BookingDetails findByBookingDetailsByPatientId(@Valid Long id);

    Billdetails billdetailsByBookingId(@Valid Long id);
}
