package com.trainingapps.bedavailabilty.bookingms.dto;

import com.trainingapps.bedavailabilty.bookingms.constants.BookingStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
public class BookingRequest {

    @Min(1)
    private Long patientId;
    private String bookedDateTime;
    private String occupiedDateTime;
    @NotNull
    private Double bookingAmount;
    private String releaseDate;
    @NotBlank
    private String bookingStatus;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getBookedDateTime() {
        return bookedDateTime;
    }

    public void setBookedDateTime(String bookedDateTime) {
        this.bookedDateTime = bookedDateTime;
    }

    public String getOccupiedDateTime() {
        return occupiedDateTime;
    }

    public void setOccupiedDateTime(String occupiedDateTime) {
        this.occupiedDateTime = occupiedDateTime;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
