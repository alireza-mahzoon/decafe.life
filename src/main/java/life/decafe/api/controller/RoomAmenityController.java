package life.decafe.api.controller;

import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.repository.RoomAmenityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;

@RestController
public class RoomAmenityController {
  private static final Logger LOGGER = LoggerFactory.getLogger(RoomAmenityController.class);
  private final RoomAmenityRepository roomAmenityRepository;

  @Autowired
  public RoomAmenityController(RoomAmenityRepository roomAmenityRepository) { this.roomAmenityRepository = roomAmenityRepository;
  }

  @GetMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/roomamenity", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<RoomAmenity>> getAllRoomAmenities(@PathVariable Long hotelId, @PathVariable Long roomtypeId) {
    LOGGER.info("Reteriving all roomAmenities");
    List<RoomAmenity> roomAmenities = roomAmenityRepository.findAllByRoomTypeId(roomtypeId);
    return ResponseEntity.ok(roomAmenities);
  }

  @PostMapping(value = "/hotel/{hotelId}/roomtype/{roomtypeId}/roomamenity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RoomAmenity> createRoomAmenity(@RequestBody RoomAmenity roomamenity, @PathVariable Long hotelId, @PathVariable Long roomtypeId) {
    LOGGER.info("Creating a roomAmenity for hotel with id={} and roomType with Id={}", hotelId, roomtypeId );
    RoomAmenity roomAmenity = roomAmenityRepository.save(roomamenity);
    return ResponseEntity.ok(roomAmenity);
  }
}
