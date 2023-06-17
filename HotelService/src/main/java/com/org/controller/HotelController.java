package com.org.controller;

import com.org.entity.Hotel;
import com.org.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        return hotelService.getAllHotel();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id)
    {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
    {
        return hotelService.create(hotel);
    }
}
