package com.example.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

    @Autowired
    BookgingService bookgingService;

    @Test
    public void bookingServiceDaysCalculatorTest() {
        String name = "Bruna";
        Integer days = bookgingService.daysCalcylatorWithDataBase(name);

        Assertions.assertEquals(days, 10);

    }

}
