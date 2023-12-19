package com.HotelService.HotelService.service;

import com.HotelService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAllHotels();
    Hotel getHotel(String hotelId);
}
