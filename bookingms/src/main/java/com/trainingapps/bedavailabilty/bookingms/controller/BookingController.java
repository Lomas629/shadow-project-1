package com.trainingapps.bedavailabilty.bookingms.controller;

import com.trainingapps.bedavailabilty.bookingms.dto.*;
import com.trainingapps.bedavailabilty.bookingms.exceptions.BookingNotFoundException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingAmountException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingIdException;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingTypeException;
import com.trainingapps.bedavailabilty.bookingms.repository.IBookingRepository;
import com.trainingapps.bedavailabilty.bookingms.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/booking")
@RestController
public class BookingController {

    @Autowired
    private IBookingService service;


    @GetMapping("/home")
    public String home(){
        String str="Welcome to booking app";
        return str;
    }

    /*
     * @url booking/book
     * @param BookingRequest
     * @return details
     *
     * To book booking details to database
     *
     */
    @PostMapping("/add")
    public BookingDetails book(@RequestBody BookingRequest request) throws Exception {
        BookingDetails details = service.book(request);
        return details;
    }

    /*
     * @url booking/update
     * @param UpdateBooking
     * @return details
     *
     * To update booking details to database
     *
     */
    @PutMapping("/update")
    public BookingDetails update(@RequestBody UpdateBooking booking) throws Exception {
        BookingDetails details = service.update(booking);
        return details;
    }

    /*
     * @url booking/cancel
     * @param UnBookingBooking
     * @return details
     *
     * To cancel booking details to database
     *
     */
    @PutMapping("/cancel")
    public BookingDetails cancel(@RequestBody UnBookingRequest request) throws Exception {
        BookingDetails details = service.cancel(request);
        return details;
    }

    /*
     * @url bookingdetails/bypatientId/
     * @param Long
     * @return details
     *
     * To fetch booking details by id from database
     *
     */
    @GetMapping("/bookingdetails/bypatientId/{id}")
    public BookingDetails bookingDetailsById(@PathVariable("id") Long id){
        BookingDetails details = service.findByBookingDetailsByPatientId(id);
        return details;
    }

    /*
     * @url billdetails/bypatientId/
     * @param Long
     * @return billdetails
     *
     * To fetch bill details by id from database
     *
     */
    @GetMapping("/billdetails/bypatientId/{id}")
    public Billdetails billdetailsByBookingId(@PathVariable("id") Long id){
        Billdetails billdetails = service.billdetailsByBookingId(id);
        return billdetails;
    }

}


