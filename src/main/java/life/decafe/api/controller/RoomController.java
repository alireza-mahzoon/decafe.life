package life.decafe.api.controller;

import life.decafe.api.model.entity.Room;
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
}
