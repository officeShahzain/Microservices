package com.HotelService.HotelService.controllers;

import com.HotelService.HotelService.entities.Hotel;
import com.HotelService.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
   @Autowired
    HotelService hotelService;
   @PostMapping("/add")
   public ResponseEntity<String> createHotel(@RequestBody Hotel hotel)
   {
       hotelService.create(hotel);
       return ResponseEntity.ok(hotel.getName()+" save SuccessFully !!");
   }
   @GetMapping("/getAll")
   public ResponseEntity<List<Hotel>> getAll()
   {
       List<Hotel> allHotels = hotelService.getAllHotels();
       return new ResponseEntity<>(allHotels, HttpStatus.FOUND);
   }
   @GetMapping("/get/{hotelId}")
   public ResponseEntity<Hotel> getHotel(@PathVariable("hotelId")String hotelId)
   {
       Hotel hotel = hotelService.getHotel(hotelId);
       return new ResponseEntity<>(hotel, HttpStatus.OK);
   }
}
