package com.trainingapps.bedavailabilty.bookingms.repository;

import com.trainingapps.bedavailabilty.bookingms.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface IBookingRepository extends JpaRepository<Booking,Long> {
    @Query("select b from Booking b WHERE b.patientId =:pid")
    Booking findDetailsByPatientId(@Param("pid") Long PatientId);
}
