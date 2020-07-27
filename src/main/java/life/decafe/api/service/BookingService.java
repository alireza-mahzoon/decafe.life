package life.decafe.api.service;

import life.decafe.api.model.entity.Booking;

public interface BookingService {

  /**
   * Create new booking
   * @param booking
   * @return newly created booking
   */
  Booking createBooking(Booking booking);
}
