package life.decafe.api.controller;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

  @GetMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
    LOGGER.info("Retrieving booking by Id={}", bookingId);
    Optional<Booking> booking = bookingRepository.findById(bookingId);
    if(booking.isPresent()) {
      return ResponseEntity.ok(booking.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
    LOGGER.info("Creating a booking");
    Booking bookingCreated = bookingRepository.save(booking);
    return ResponseEntity.ok(bookingCreated);
  }

  @PutMapping(value = "/{bookingId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
    LOGGER.info("Update a booking with Id={}", bookingId);
    Booking bookingUpdated = bookingRepository.save(booking);
    return ResponseEntity.ok(bookingUpdated);
  }

  @DeleteMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
    LOGGER.info("Deleting a booking with Id={}", bookingId);
    bookingRepository.deleteById(bookingId);
    return ResponseEntity.noContent().build();
  }
}
