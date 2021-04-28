package com.example.tdd.controller;

import com.example.tdd.model.BookingModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void booking_GetAllTest() throws Exception {
        mockMvc.perform(get("/bookings")).andExpect(status().isOk());
    }

    @Test
    public void booking_PostTest() throws Exception {

        LocalDate checkIn = LocalDate.parse("2021-11-01");
        LocalDate checkOut = LocalDate.parse("2021-11-11");
        BookingModel bookingModel = new BookingModel("1", "Bruna", checkIn, checkOut, 2);

        mockMvc.perform(post("/bookings")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bookingModel)))
               .andExpect(status().isOk());

    }

}
