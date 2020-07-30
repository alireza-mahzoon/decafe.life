package life.decafe.api.service;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.model.rest.HotelAmenityDto;

import java.util.List;
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
  Optional<HotelAmenityDto> findHotelAmenityById(Long hotelAmenityId);

  /**
   * Update a hotel amenity
   * @param hotelAmenity
   * @return Updated hotel amenity
   */
  HotelAmenityDto updateHotelAmenity(HotelAmenityDto hotelAmenity);

  /**
   * Find all hotel amenities for with hotelAmenity Id
   * @param hotelId
   * @return List of hotel amenities
   */
  List<HotelAmenityDto> findAllHotelAmenities(Long hotelId);

  /**
   * Delete a hotel amenity
   * @param hotelAmenityId
   * @return
   */
  Void deleteHotelAmenityById(Long hotelAmenityId);
}
