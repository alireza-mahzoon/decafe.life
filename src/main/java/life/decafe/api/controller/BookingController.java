package life.decafe.api.controller;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);
  private final BookingRepository bookingRepository;

  @Autowired
  public BookingController(BookingRepository bookingRepository) { this.bookingRepository = bookingRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Booking>> getAllBookings() {
    LOGGER.info("Retrieving all bookings");
    List<Booking> bookings = bookingRepository.findAll();
    return ResponseEntity.ok(bookings);
  }
}
