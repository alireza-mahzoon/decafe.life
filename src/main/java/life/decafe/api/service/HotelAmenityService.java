package life.decafe.api.service;

import life.decafe.api.model.entity.HotelAmenity;

public interface HotelAmenityService {

  /**
   * Create a new hotel amenity
   * @param hotelAmenity
   * @return newly created hotel amenity
   */
  HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity);
}
