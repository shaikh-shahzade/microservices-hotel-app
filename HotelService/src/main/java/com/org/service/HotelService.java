package com.org.service;


import com.org.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    ResponseEntity<List<Hotel>> getAllHotel();

    ResponseEntity<Hotel> getHotelById(Long id);

    ResponseEntity<Hotel> create(Hotel hotel);
}
