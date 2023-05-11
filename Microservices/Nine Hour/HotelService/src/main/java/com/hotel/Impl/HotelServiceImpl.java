package com.hotel.Impl;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResoureceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {

       String hotelId= UUID.randomUUID().toString();//unique Id generated
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResoureceNotFoundException("hotel with given id not found"));
    }
}
