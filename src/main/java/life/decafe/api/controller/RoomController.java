package life.decafe.api.controller;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.entity.RoomType;
import life.decafe.api.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);
  private final RoomRepository roomRepository;

  @Autowired
  public RoomController(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @GetMapping(value = "/hotel/{hotelId}/room", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Room>> getAllRooms(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all rooms");
    List<Room> rooms = roomRepository.findAllByHotelId(hotelId);
    return ResponseEntity.ok(rooms);
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/room", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Room> createRoom(@RequestBody Room room, @PathVariable Long roomtypeId, @PathVariable Long hotelId) {
    LOGGER.info("Creating a room with roomTypeId={} and hotelId={}", roomtypeId, hotelId);
    Room roomCreated = roomRepository.save(room);
    return ResponseEntity.ok(roomCreated);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/room/{roomId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Room> updateRoom(@RequestBody Room room, @PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long roomId) {
    LOGGER.info("Updating a room with Id ={}, with hotelId={} and roomTypeId={}", roomId, hotelId, roomtypeId);
    Room roomUpdated = roomRepository.save(room);
    return ResponseEntity.ok(roomUpdated);
  }

  @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> countRooms() {
    LOGGER.info("Counting number of rooms");
    Long countRooms = roomRepository.count();
    return ResponseEntity.ok(countRooms);
  }
}
