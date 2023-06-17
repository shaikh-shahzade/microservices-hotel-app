package com.org.serviceimpl;

import com.org.entity.Hotel;
import com.org.exception.ResourceNotFoundExceptions;
import com.org.repository.HotelRepository;
import com.org.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> hotels = hotelRepository.findAll();
        return new ResponseEntity<List<Hotel>>(hotels , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hotel> getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundExceptions("Hotel","Hotel-Id",id));
        return new ResponseEntity<Hotel>(hotel , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hotel> create(Hotel hotel) {
        Hotel h = hotelRepository.save(hotel);
        return new ResponseEntity<Hotel>(h, HttpStatus.CREATED);
    }
}
