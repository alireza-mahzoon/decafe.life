package life.decafe.api.service;

import life.decafe.api.model.entity.HotelAmenity;

import java.util.Optional;

public interface HotelAmenityService {

  /**
   * Create a new hotel amenity
   * @param hotelAmenity
   * @return newly created hotel amenity
   */
  HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity);

  /**
   * Find hotel amenity by its Id
   * @param hotelAmenityId hotel amenity Id
   * @return Hotel amenity if exists, empty otherwise
   */
  Optional<HotelAmenity> findHotelAmenityById(Long hotelAmenityId);

  /**
   * Update a hotel amenity
   * @param hotelAmenity
   * @return Updated hotel amenity
   */
  HotelAmenity updateHotelAmenity(HotelAmenity hotelAmenity);
}
