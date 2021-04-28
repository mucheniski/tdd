package com.example.tdd.service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public Integer daysCalcylatorWithDataBase(String name) {
        Optional<BookingModel> bookingModel = repository.findByReseveName(name);
        Integer days = bookingModel.get().daysReserved();
        return days;
    }

}
