package com.aravind.springtransactions.utils;

import com.aravind.springtransactions.exception.InsufficientFundsException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc01",12000.0);
        paymentMap.put("acc02",11000.0);
        paymentMap.put("acc03",10000.0);
        paymentMap.put("acc04",9000.0);
    }

    public static boolean validateCreditLimit(String accNo, Double paidAmount) {
        System.out.println(accNo);
        if(paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientFundsException("insufficient funds.");
        } else {
            return true;
        }
    }

}
