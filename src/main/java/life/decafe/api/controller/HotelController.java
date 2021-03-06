package life.decafe.api.controller;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HotelController.class);
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<HotelDto>> getAllHotels() {
    LOGGER.info("Retrieving all hotels");
    List<HotelDto> hotels = hotelService.findAllHotels();
    return ResponseEntity.ok(hotels);
  }

  @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> countHotels() {
    LOGGER.info("Counting number of hotels");
    Long countHotels = hotelService.countHotels();
    return ResponseEntity.ok(countHotels);
  }

  @DeleteMapping(value = "/{hotelId}")
  public ResponseEntity<Void> deleteHotelById(@PathVariable Long hotelId) {
    LOGGER.info("Deleting hotel by Id={}", hotelId);
    hotelService.deleteById(hotelId);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelDto> createHotel(@Validated @RequestBody HotelDto hotel) {
    LOGGER.info("Creating a hotel");
    HotelDto hotelCreated = hotelService.createHotel(hotel);
    return ResponseEntity.ok(hotelCreated);
  }

  @PutMapping(value = "/{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelDto> updateHotelById(@RequestBody @Validated HotelDto hotel, @PathVariable Long hotelId) {
    LOGGER.info("Update a hotel");
    if (!hotel.getId().equals(hotelId)) {
      throw new BadRequestException("The hotelId in the end point is not equal to method argument");
    }
    HotelDto updatedHotel = hotelService.updateHotel(hotel);
    return ResponseEntity.ok(updatedHotel);
  }

  @GetMapping(value = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving hotel by Id={}", hotelId);
    Optional<HotelDto> hotel = hotelService.findHotelById(hotelId);
    if (hotel.isPresent()) {
      return ResponseEntity.ok(hotel.get());
    }
    return ResponseEntity.notFound().build();
  }
}
