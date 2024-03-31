package com.aravind.springtransactions.service;

import com.aravind.springtransactions.dto.FlightBookingAcknowledgement;
import com.aravind.springtransactions.dto.FlightBookingRequest;
import com.aravind.springtransactions.entity.PassengerInfo;
import com.aravind.springtransactions.entity.PaymentInfo;
import com.aravind.springtransactions.repo.PassengerInfoRepository;
import com.aravind.springtransactions.repo.PaymentInfoRepository;
import com.aravind.springtransactions.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        FlightBookingAcknowledgement flightBookingAcknowledgement = null;
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountId(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),
                UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }


}
