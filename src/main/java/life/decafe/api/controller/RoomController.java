package life.decafe.api.controller;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.RoomDto;
import life.decafe.api.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);
  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping(value = "/hotel/{hotelId}/room", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Room>> getAllRooms(@PathVariable Long hotelId) {
    LOGGER.info("Retrieving all rooms");
    List<Room> rooms = roomService.findAllRooms(hotelId);
    return ResponseEntity.ok(rooms);
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/room/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomDto> findRoomById(@PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long roomId) {
    LOGGER.info("Retrieving room by Id ={}", roomId);
    Optional<RoomDto> room = roomService.findRoomById(roomId);
    if (room.isPresent()) {
      return ResponseEntity.ok(room.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/room", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto room, @PathVariable Long roomtypeId, @PathVariable Long hotelId) {
    LOGGER.info("Creating a room with roomTypeId={} and hotelId={}", roomtypeId, hotelId);
    RoomDto roomCreated = roomService.createRoom(room);
    return ResponseEntity.ok(roomCreated);
  }

  @PutMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/room/{roomId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto room, @PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long roomId) {
    LOGGER.info("Updating a room with Id ={}", roomId);
    RoomDto roomUpdated = roomService.updateRoom(room);
    return ResponseEntity.ok(roomUpdated);
  }

  @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> countRooms() {
    LOGGER.info("Counting number of rooms");
    Long countRooms = roomService.countRooms();
    return ResponseEntity.ok(countRooms);
  }

  @DeleteMapping(value = "hotel/{hotelId}/roomtype/{roomtypeId}/room/{roomId}")
  public ResponseEntity<Void> delteRoomById(@PathVariable Long hotelId, @PathVariable Long roomtypeId, @PathVariable Long roomId) {
    LOGGER.info("Deleting room by id={}", roomId);
    roomService.deleteRoom(roomId);
    return ResponseEntity.noContent().build();
  }
}
