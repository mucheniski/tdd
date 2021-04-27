package com.example.tdd.service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookginRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

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

    @MockBean
    BookginRepository bookginRepository;

    @BeforeEach
    public void setUp() {
        LocalDate checkIn = LocalDate.parse("2021-11-01");
        LocalDate checkOut = LocalDate.parse("2021-11-11");
        BookingModel bookingModel = new BookingModel("1", "Bruna", checkIn, checkOut, 2);

        Mockito.when(bookginRepository.findByReseveName(bookingModel.getReserveName())).thenReturn(Optional.of(bookingModel));

    }

    @Test
    public void bookingServiceDaysCalculatorTest() {
        String name = "Bruna";
        Integer days = bookgingService.daysCalcylatorWithDataBase(name);

        Assertions.assertEquals(days, 10);

    }

}
