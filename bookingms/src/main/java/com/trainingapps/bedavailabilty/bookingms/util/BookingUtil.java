package com.trainingapps.bedavailabilty.bookingms.util;

import com.trainingapps.bedavailabilty.bookingms.constants.BookingStatus;
import com.trainingapps.bedavailabilty.bookingms.dto.BookingDetails;
import com.trainingapps.bedavailabilty.bookingms.entity.Booking;
import com.trainingapps.bedavailabilty.bookingms.exceptions.InvalidBookingTypeException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BookingUtil {
    public LocalDateTime toLocalDateTime(String dateTimeString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime;
    }

    public BookingStatus toEnum(String status) throws InvalidBookingTypeException {
        BookingStatus[] statuses = BookingStatus.values();
        for(BookingStatus iterator:statuses){
            String iteratedStatus = iterator.toString();
            if(iteratedStatus.equalsIgnoreCase(status))
                return iterator;
        }
        throw new InvalidBookingTypeException("Invalid booking status");
    }

    public BookingDetails toBookingDetails(Booking booking) {
        BookingDetails details = new BookingDetails();
        details.setId(booking.getId());
        details.setBookingStatus(booking.getBookingStatus().toString());
        details.setBookingAmount(booking.getBookingAmount());
        details.setBookedDateTime(String.valueOf(booking.getBookedDateTime()));
        details.setOccupiedDateTime(String.valueOf(booking.getOccupiedDateTime()));
        details.setPatientId(booking.getPatientId());
        details.setReleaseDate(String.valueOf(booking.getReleaseDate()));
        return details;
    }
}
