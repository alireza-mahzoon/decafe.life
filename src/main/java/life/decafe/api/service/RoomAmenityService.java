package life.decafe.api.service;

import life.decafe.api.model.entity.RoomAmenity;

import java.util.List;
import java.util.Optional;

public interface RoomAmenityService {

  /**
   * Create new room amenity
   * @param roomAmenity
   * @return newly created room amenity
   */
   RoomAmenity createRoomAmenity(RoomAmenity roomAmenity);


  /**
   * Find room amenity by its Id
   * @param roomAmenityId
   * @return room amenity if exists, empty optional otherwise
   */
   Optional<RoomAmenity> findRoomAmenityById(Long roomAmenityId);

  /**
   * Find all room amenities in a room type
   * @param roomtypeId
   * @return List of room amenities
   */
   List<RoomAmenity> findAllRoomAmenities(Long roomtypeId);

  /**
   * Update a room amenity
   * @param roomAmenity
   * @return Updated room amenity
   */
   RoomAmenity updateRoomAmenity(RoomAmenity roomAmenity);
}
