package life.decafe.api.service;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.rest.HotelDto;

import java.util.List;
import java.util.Optional;

public interface HotelService {

  /**
   * Create new hotel
   * @param hotelDto hotel
   * @return newly created hotel
   */
  HotelDto createHotel(HotelDto hotelDto);

  /**
   * Find hotel by its Id
   * @param hotelId hotel Id
   * @return hotel if exists, empty optional otherwise
   */
  Optional<Hotel> findHotelById(Long hotelId);

  /**
   * Find all hotels
   * @param
   * @return hotel list
   */
  List<Hotel> findAllHotels();

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
  Void deleteById(Long hotelId);

  /**
   * Update hotel
   * @param hotel
   * @return Updated hotel
   */
  Hotel updateHotel(Hotel hotel);
}
