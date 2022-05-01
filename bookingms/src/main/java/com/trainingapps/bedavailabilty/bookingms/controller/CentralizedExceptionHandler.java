package com.trainingapps.bedavailabilty.bookingms.controller;

import com.trainingapps.bedavailabilty.bookingms.entity.Booking;
import com.trainingapps.bedavailabilty.bookingms.exceptions.BookingNotFoundException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingAmountException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingIdException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * Central Controller class exception to be thrown to REST end points
 *
 *
 *
 */
@RestControllerAdvice
@Component
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BookingNotFoundException.class)
    public String handleBookingNotFound(BookingNotFoundException e){

        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value= {
            InvalidBookingIdException.class,
            InvalidBookingTypeException.class,
            InvalidBookingAmountException.class,
            NullPointerException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalid(Exception e){
        return e.getMessage();
    }
}
