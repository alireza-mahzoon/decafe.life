package life.decafe.api.controller;

import life.decafe.api.model.entity.RoomType;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class RoomTypeController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomTypeController.class);
  private final RoomTypeRepository roomTypeRepository;
  private final RoomTypeService roomTypeService;

  @Autowired
  public RoomTypeController(RoomTypeRepository roomTypeRepository, RoomTypeService roomTypeService) { this.roomTypeRepository = roomTypeRepository;
    this.roomTypeService = roomTypeService;
  }

  @GetMapping(value = "/countRoomTypes")
  public ResponseEntity<Long> countRoomTypes() {
    LOGGER.info("Counting number of roomTypes");
    Long countRoomTypes = roomTypeRepository.count();
    return ResponseEntity.ok(countRoomTypes);
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomType> findRoomTypeById(@PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Retrieving room type with Id={}", roomTypeId);
    Optional<RoomType> roomType = roomTypeService.findRoomTypeById(roomTypeId);
    if (roomType.isPresent()) {
      return ResponseEntity.ok(roomType.get());
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RoomType>> getAllRoomTypes(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all roomTypes");
    List<RoomType> roomTypes = roomTypeService.findAllRoomTypes(hotelId);
    return ResponseEntity.ok(roomTypes);
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomtype, @PathVariable Long hotelId) {
    LOGGER.info("Create a roomType for a hotel with id={}", hotelId);
    RoomType createdRoomType = roomTypeService.createRoomType(roomtype);
    return ResponseEntity.ok(createdRoomType);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomtype, @PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Updating a roomType with id={} and hotelId ={}", roomTypeId, hotelId);
    RoomType roomTypeUpdated = roomTypeService.updateRoomType(roomtype);
    return ResponseEntity.ok(roomTypeUpdated);
  }

  @DeleteMapping(value = "/hotel/{hotelId}/roomtype/{roomTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteRoomTypeById(@PathVariable Long hotelId, @PathVariable Long roomTypeId) {
    LOGGER.info("Deleting a roomType with id={}", roomTypeId);
    roomTypeService.deleteRoomType(roomTypeId);
    return ResponseEntity.noContent().build();
  }
}
