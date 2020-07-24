package life.decafe.api.service;

import life.decafe.api.model.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

  /**
   * Create new hotel
   * @param hotel hotel
   * @return newly created hotel
   */
  Hotel createHotel(Hotel hotel);

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
}
