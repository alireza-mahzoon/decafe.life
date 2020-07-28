package life.decafe.api.controller;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.repository.HotelAmenityRepository;
import life.decafe.api.service.HotelAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HotelAmenityController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HotelAmenityController.class);
  private final HotelAmenityRepository hotelAmenityRepository;
  private final HotelAmenityService hotelAmenityService;

  public HotelAmenityController(HotelAmenityRepository hotelAmenityRepository, HotelAmenityService hotelAmenityService) {this.hotelAmenityRepository = hotelAmenityRepository;
    this.hotelAmenityService = hotelAmenityService;
  }

  @GetMapping(value = "/hotel/{hotelId}/amenity",  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<HotelAmenity>> getAllHotelAmenities(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all hotel amenities");
    List<HotelAmenity> hotelAmenities = hotelAmenityService.findAllHotelAmenities(hotelId);
    return ResponseEntity.ok(hotelAmenities);
  }

  @GetMapping(value = "/amenity/{amenityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelAmenity> findHotelAmenity(@PathVariable Long amenityId) {
    LOGGER.info("Find a hotel amenity with Id={}", amenityId);
    Optional<HotelAmenity> hotelAmenity = hotelAmenityService.findHotelAmenityById(amenityId);
    if (hotelAmenity.isPresent()) {
      return ResponseEntity.ok(hotelAmenity.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/hotel/{hotelId}/amenity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelAmenity> createHotelAmenity(@RequestBody HotelAmenity amenity, @PathVariable Long hotelId) {
    LOGGER.info("Create a hotel amenity");
    HotelAmenity CreatedHotelAmenity = hotelAmenityService.createHotelAmenity(amenity);
    return ResponseEntity.ok(CreatedHotelAmenity);
  }

  @PutMapping(value = "/hotel/{hotelId}/amenity/{hotelAmenityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelAmenity> updateHotelAmenity(@RequestBody HotelAmenity hotelAmenity, @PathVariable Long hotelId, @PathVariable Long hotelAmenityId) {
    LOGGER.info("Update a hotel amenity with id={} for hotel with id={}", hotelAmenityId, hotelId);
    HotelAmenity updatedHotelAmenity = hotelAmenityService.updateHotelAmenity(hotelAmenity);
    return ResponseEntity.ok(updatedHotelAmenity);
  }

  @DeleteMapping(value = "/hotel/{hotelId}/amenity/{hotelAmenityId}")
  public ResponseEntity<Void> deleteHotelAmenityById(@PathVariable Long hotelId, @PathVariable Long hotelAmenityId) {
    LOGGER.info("Delete a hotel amenity with Id={}", hotelAmenityId);
    hotelAmenityRepository.deleteById(hotelAmenityId);
    return ResponseEntity.noContent().build();
  }
}
