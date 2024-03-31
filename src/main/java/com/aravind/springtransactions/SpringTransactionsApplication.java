package com.aravind.springtransactions;

import com.aravind.springtransactions.dto.FlightBookingAcknowledgement;
import com.aravind.springtransactions.dto.FlightBookingRequest;
import com.aravind.springtransactions.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class SpringTransactionsApplication {
	@Autowired
	private FlightBookingService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionsApplication.class, args);
	}

	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}

}
