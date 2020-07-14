package life.decafe.api.controller;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloController {
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
  private final HotelRepository hotelRepository;

  @Autowired
  public HelloController(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @GetMapping
  public ResponseEntity<String> hello() {
    LOGGER.info("Serving hello request");
    return ResponseEntity.ok("Hello World");
  }

  @GetMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, String>> message() {
    LOGGER.info("Serving message request");
    Map<String, String> message = new HashMap<>();
    message.put("message", "hello world");
    return ResponseEntity.ok(message);
  }
}
