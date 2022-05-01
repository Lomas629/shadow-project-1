package com.trainingapps.bedavailabilty.bookingms.entity;

import com.trainingapps.bedavailabilty.bookingms.constants.BookingStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "bookings")
@Entity
public class Booking {

    @GeneratedValue
    @Id
    private Long id;

    private Long patientId;
    private LocalDateTime bookedDateTime;
    private LocalDateTime occupiedDateTime;
    private Double bookingAmount;
    private LocalDateTime releaseDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    public Booking(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getBookedDateTime() {
        return bookedDateTime;
    }

    public void setBookedDateTime(LocalDateTime bookedDateTime) {
        this.bookedDateTime = bookedDateTime;
    }

    public LocalDateTime getOccupiedDateTime() {
        return occupiedDateTime;
    }

    public void setOccupiedDateTime(LocalDateTime occupiedDateTime) {
        this.occupiedDateTime = occupiedDateTime;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        return id.equals(booking.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}