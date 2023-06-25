package com.org.serviceimpl;

import com.org.Exception.ResourceNotFoundException;
import com.org.entity.User;
import com.org.payload.Hotel;
import com.org.payload.Rating;
import com.org.repository.UserRepository;
import com.org.service.HotelService;
import com.org.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
//        users.forEach((u)-> {
//                    List<Rating> ratings = restTemplate.getForObject("http://localhost:8083/rating/user/"+u.getId()
//                            , ArrayList.class);
//                    logger.info("Logged value Ratings: {}",ratings);
//                    u.setRatings(ratings);
//        });

        List<Hotel> hotels = hotelService.getAllHotels();
        System.out.println(hotels);
        return new ResponseEntity<>(users , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        User u = userRepository.save(user);
        return new ResponseEntity<>(u , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","User-id",id));
        List<Rating> ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getId()
                    , ArrayList.class);
        user.setRatings(ratings);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }
}
