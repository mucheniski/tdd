package com.example.tdd.service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookginRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookgingService {

    @Autowired
    BookginRepository repository;

    public Integer daysCalcylatorWithDataBase(String name) {
        Optional<BookingModel> bookingModel = repository.findByReseveName(name);
        Integer days = bookingModel.get().daysReserved();
        return days;
    }

}
