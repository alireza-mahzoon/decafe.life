package life.decafe.api.controller;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.model.rest.BookingDto;
import life.decafe.api.repository.BookingRepository;
import life.decafe.api.service.BookingService;
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
  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingRepository bookingRepository, BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookingDto>> getAllBookings() {
    LOGGER.info("Retrieving all bookings");
    List<BookingDto> bookings = bookingService.findAllBooking();
    return ResponseEntity.ok(bookings);
  }

  @GetMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookingDto> getBookingById(@PathVariable Long bookingId) {
    LOGGER.info("Retrieving booking by Id={}", bookingId);
    Optional<BookingDto> booking = bookingService.findBookingById(bookingId);
    if(booking.isPresent()) {
      return ResponseEntity.ok(booking.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
    LOGGER.info("Creating a booking");
    Booking bookingCreated = bookingService.createBooking(booking);
    return ResponseEntity.ok(bookingCreated);
  }

  @PutMapping(value = "/{bookingId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto booking, @PathVariable Long bookingId) {
    LOGGER.info("Update a booking with Id={}", bookingId);
    BookingDto bookingUpdated = bookingService.updateBooking(booking);
    return ResponseEntity.ok(bookingUpdated);
  }

  @DeleteMapping(value = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
    LOGGER.info("Deleting a booking with Id={}", bookingId);
    bookingService.deleteBooking(bookingId);
    return ResponseEntity.noContent().build();
  }
}
