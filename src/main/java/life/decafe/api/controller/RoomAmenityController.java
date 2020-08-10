package life.decafe.api.controller;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.model.rest.RoomAmenityDto;
import life.decafe.api.service.RoomAmenityService;
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
public class RoomAmenityController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomAmenityController.class);
  private final RoomAmenityService roomAmenityService;

  @Autowired
  public RoomAmenityController(RoomAmenityService roomAmenityService) {
    this.roomAmenityService = roomAmenityService;
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/amenity", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RoomAmenityDto>> getAllRoomAmenities(@PathVariable Long hotelId, @PathVariable Long roomtypeId) {
    LOGGER.info("Retrieving all room amenities");
    List<RoomAmenityDto> roomAmenities = roomAmenityService.findAllRoomAmenities(roomtypeId);
    return ResponseEntity.ok(roomAmenities);
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/amenity/{amenityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomAmenityDto> getRoomAmenity(@PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long amenityId) {
    LOGGER.info("Retrieving a room amenity Id = {}", amenityId);
    Optional<RoomAmenityDto> roomAmenity = roomAmenityService.findRoomAmenityById(amenityId);
    if (roomAmenity.isPresent()) {
      return ResponseEntity.ok(roomAmenity.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}/amenity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomAmenityDto> createRoomAmenity(@RequestBody @Validated RoomAmenityDto amenity, @PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Creating a room amenity for hotel with hotelId={} and room type with Id={}", hotelId, roomTypeId );
    if (!amenity.getRoomTypeId().equals(roomTypeId)) {
      throw new BadRequestException("The roomTypeId in the end point is not equal to method argument");
    }
    RoomAmenityDto roomAmenity = roomAmenityService.createRoomAmenity(amenity);
    return ResponseEntity.ok(roomAmenity);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/amenity/{roomamenityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomAmenityDto> updateRoomAmenity(@RequestBody @Validated RoomAmenityDto roomAmenity, @PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long roomamenityId) {
    LOGGER.info("Updating room amenity with id={}", roomamenityId);
    if (!roomAmenity.getRoomTypeId().equals(roomtypeId)) {
      throw new BadRequestException("The roomTypeId in the end point is not equal to method argument");
    }
    if (roomAmenity.getId().equals(roomamenityId)) {
      throw new BadRequestException("The room amenity Id in the end point is not equal to method argument");
    }
    RoomAmenityDto roomamenityUpdated = roomAmenityService.updateRoomAmenity(roomAmenity);
    return ResponseEntity.ok(roomAmenity);
  }

  @DeleteMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeid}/amenity/{amenityid}")
  public ResponseEntity<Void> deleteRoomAmenityById(@PathVariable Long hotelId, @PathVariable Long roomtypeid, @PathVariable Long amenityid) {
    LOGGER.info("Delete a room amenity by id={}", amenityid);
    roomAmenityService.deleteRoomAmenityById(amenityid);
    return ResponseEntity.noContent().build();
  }
}
