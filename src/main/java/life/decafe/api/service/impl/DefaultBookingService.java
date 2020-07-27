package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.repository.BookingRepository;
import life.decafe.api.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DefaultBookingService implements BookingService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBookingService.class);
  private final BookingRepository bookingRepository;

  public DefaultBookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }


  @Override
  public Booking createBooking(Booking booking) {
    LOGGER.debug("Create a booking");
    return bookingRepository.save(booking);
  }

  @Override
  public Optional<Booking> findBookingById(Long bookingId) {
    LOGGER.debug("Find a booking by Id={}", bookingId);
    bookingRepository.findById(bookingId);
    return Optional.empty();
  }

  @Override
  public List<Booking> findAllBooking() {
    LOGGER.debug("Find all bookings");
    return bookingRepository.findAll();
  }

  @Override
  public Booking updateBooking(Booking booking) {
    LOGGER.debug("Update a booking");
    return bookingRepository.save(booking);
  }
}
