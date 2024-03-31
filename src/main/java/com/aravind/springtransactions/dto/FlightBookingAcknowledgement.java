package com.aravind.springtransactions.dto;

import com.aravind.springtransactions.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {

    private String status;
    private double fare;
    private String pnrNo;
    private PassengerInfo passengerInfo;

}
