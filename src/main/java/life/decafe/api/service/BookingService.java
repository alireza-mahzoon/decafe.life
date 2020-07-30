package life.decafe.api.service;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.model.rest.BookingDto;

import java.util.List;
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
  Optional<BookingDto> findBookingById(Long bookingId);

  /**
   * Find all bookings
   * @param
   * @return list of bookings
   */
  List<BookingDto> findAllBooking();

  /**
   * Update a booking
   * @param booking
   * @return updated booking
   */
  BookingDto updateBooking(BookingDto booking);

  /**
   * Delete a booking
   * @param bookingId
   * @return
   */
  Void deleteBooking(Long bookingId);
}
