package com.HotelService.HotelService.service.Impl;

import com.HotelService.HotelService.entities.Hotel;
import com.HotelService.HotelService.exception.ResourceNotFoundException;
import com.HotelService.HotelService.repository.HotelRepository;
import com.HotelService.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotelRepo.findAll();
        return hotels;
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("hotel is not available on serve hotelId : "+ hotelId));
    }
}
