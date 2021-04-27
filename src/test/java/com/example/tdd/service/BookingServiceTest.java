package com.example.tdd.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

    /*
     * Bean para ser utilizado apenas nos testes, ao chamar o teste é instanciado o bean
     * */
    @TestConfiguration
    static class BookingServiceTestConfig {
        @Bean
        public BookgingService bookgingService() {
            return new BookgingService();
        }
    }

    @Autowired
    BookgingService bookgingService;

    @Test
    public void bookingServiceDaysCalculatorTest() {
        String name = "Bruna";
        Integer days = bookgingService.daysCalcylatorWithDataBase(name);

        Assertions.assertEquals(days, 10);

    }

}
