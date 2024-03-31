package com.aravind.springtransactions.repo;

import com.aravind.springtransactions.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long > {
}
