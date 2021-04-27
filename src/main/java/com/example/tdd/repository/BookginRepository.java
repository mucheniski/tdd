package com.example.tdd.repository;

import com.example.tdd.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookginRepository extends JpaRepository<BookingModel, String> {

    Optional<BookingModel> findByReseveName(String name);

}
