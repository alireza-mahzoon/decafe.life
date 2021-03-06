package life.decafe.api.service;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.rest.HotelDto;

import java.util.List;
import java.util.Optional;

public interface HotelService {

  /**
   * Create new hotel
   * @param hotel hotel
   * @return newly created hotel
   */
  HotelDto createHotel(HotelDto hotel);

  /**
   * Find hotel by its Id
   * @param hotelId hotel Id
   * @return hotel if exists, empty optional otherwise
   */
  Optional<HotelDto> findHotelById(Long hotelId);

  /**
   * Find all hotels
   * @param
   * @return hotel list
   */
  List<HotelDto> findAllHotels();

  /**
   * Count number of hotels
   * @param
   * @return number of hotels
   */
  Long countHotels();

  /**
   * Delete hotel by Id
   * @param hotelId hotel Id
   * @return
   */
  void deleteById(Long hotelId);

  /**
   * Update hotel
   * @param hotel
   * @return Updated hotel
   */
  HotelDto updateHotel(HotelDto hotel);
}
