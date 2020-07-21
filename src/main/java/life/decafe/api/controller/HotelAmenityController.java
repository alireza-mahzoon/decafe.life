package life.decafe.api.controller;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.repository.HotelAmenityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class HotelAmenityController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HotelAmenityController.class);
  private final HotelAmenityRepository hotelAmenityRepository;

  @Autowired
  public HotelAmenityController(HotelAmenityRepository hotelAmenityRepository) {this.hotelAmenityRepository = hotelAmenityRepository; }

  @GetMapping(value = "/hotel/{hotelId}/amenity",  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<HotelAmenity>> getAllHotelAmenities() {
    LOGGER.info("Retrieving all hotel amenities");
    List<HotelAmenity> hotelAmenities = hotelAmenityRepository.findAll();
    return ResponseEntity.ok(hotelAmenities);
  }
}
