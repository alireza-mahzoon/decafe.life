package life.decafe.api.service;

import life.decafe.api.model.entity.Booking;

import java.util.Optional;

public interface BookingService {

  /**
   * Create new booking
   * @param booking
   * @return newly created booking
   */
  Booking createBooking(Booking booking);

  /**
   * Find a booking by its Id
   * @param bookingId
   * @return booking if exists, empty optional otherwise
   */
  Optional<Booking> findBookingById(Long bookingId);
}
