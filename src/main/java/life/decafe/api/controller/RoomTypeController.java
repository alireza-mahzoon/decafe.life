package life.decafe.api.controller;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.entity.RoomType;
import life.decafe.api.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RoomTypeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomTypeController.class);
  private final RoomTypeRepository roomTypeRepository;

  @Autowired
  public RoomTypeController(RoomTypeRepository roomTypeRepository) { this.roomTypeRepository = roomTypeRepository; }

  @GetMapping(value = "/countRoomTypes")
  public ResponseEntity<Long> countRoomTypes() {
    LOGGER.info("Counting number of roomTypes");
    Long countRoomTypes = roomTypeRepository.count();
    return ResponseEntity.ok(countRoomTypes);
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype-list", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RoomType>> getAllRoomTypes(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all roomTypes");
    List<RoomType> roomTypes = roomTypeRepository.findAllByHotelId(hotelId);
    return ResponseEntity.ok(roomTypes);
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType, @PathVariable Long hotelId) {
    LOGGER.info("Create a roomType for a hotel with id={}", hotelId);
    RoomType createdRoomType = roomTypeRepository.save(roomType);
    return ResponseEntity.ok(createdRoomType);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType, @PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Updating a roomType with id={} and hotelId ={}", roomTypeId, hotelId);
    RoomType roomTypeUpdated = roomTypeRepository.save(roomType);
    return ResponseEntity.ok(roomTypeUpdated);
  }

  @DeleteMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteRoomTypeById(@PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Deleting a roomType with id={}", roomTypeId);
    roomTypeRepository.deleteById(roomTypeId);
    return ResponseEntity.noContent().build();
  }
}
