package life.decafe.api.controller;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.model.rest.RoomTypeDto;
import life.decafe.api.service.RoomTypeService;
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

public class RoomTypeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomTypeController.class);
  private final RoomTypeService roomTypeService;

  @Autowired
  public RoomTypeController(RoomTypeService roomTypeService) {
    this.roomTypeService = roomTypeService;
  }

  @GetMapping(value = "/roomtype")
  public ResponseEntity<Long> countRoomTypes() {
    LOGGER.info("Counting number of roomTypes");
    Long countRoomTypes = roomTypeService.countRoomTypes();
    return ResponseEntity.ok(countRoomTypes);
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomTypeDto> findRoomTypeById(@PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Retrieving room type with Id={}", roomTypeId);
    Optional<RoomTypeDto> roomType = roomTypeService.findRoomTypeById(roomTypeId);
    if (roomType.isPresent()) {
      return ResponseEntity.ok(roomType.get());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RoomTypeDto>> getAllRoomTypes(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all roomTypes");
    List<RoomTypeDto> roomTypes = roomTypeService.findAllRoomTypes(hotelId);
    return ResponseEntity.ok(roomTypes);
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomTypeDto> createRoomType(@RequestBody @Validated RoomTypeDto roomtype, @PathVariable Long hotelId) {
    LOGGER.info("Create a roomType for a hotel with id={}", hotelId);
    if (!roomtype.getHotelId().equals(hotelId)) {
      throw new BadRequestException("The hotel Id in the end point is not equal to method argument");
    }
    RoomTypeDto createdRoomType = roomTypeService.createRoomType(roomtype);
    return ResponseEntity.ok(createdRoomType);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomTypeDto> updateRoomType(@RequestBody @Validated RoomTypeDto roomtype, @PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Updating a roomType with id={} and hotelId ={}", roomTypeId, hotelId);
    if (!roomtype.getHotelId().equals(hotelId)) {
      throw new BadRequestException("The hotel Id in the end point is not equal to method argument");
    }
    if (!roomtype.getId().equals(roomTypeId)) {
      throw new BadRequestException("The room type Id in the end point is not equal to method argument");
    }
    RoomTypeDto roomTypeUpdated = roomTypeService.updateRoomType(roomtype);
    return ResponseEntity.ok(roomTypeUpdated);
  }

  @DeleteMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteRoomTypeById(@PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Deleting a roomType with id={}", roomTypeId);
    roomTypeService.deleteRoomType(roomTypeId);
    return ResponseEntity.noContent().build();
  }
}
