package com.trainingapps.bedavailabilty.bookingms.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Validated
public class UpdateBooking {

    @Min(1)
    private Long id;
    @Min(1)
    private Long patientId;
    private String bookedDateTime;
    private String occupiedDateTime;
    @NotNull
    private Double bookingAmount;
    private String releaseDate;

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
