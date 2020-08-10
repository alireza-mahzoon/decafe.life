package life.decafe.api.service;

import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.model.rest.RoomAmenityDto;

import java.util.List;
import java.util.Optional;

public interface RoomAmenityService {

  /**
   * Create new room amenity
   * @param roomAmenity
   * @return newly created room amenity
   */
   RoomAmenityDto createRoomAmenity(RoomAmenityDto roomAmenity);

  /**
   * Find room amenity by its Id
   * @param roomAmenityId
   * @return room amenity if exists, empty optional otherwise
   */
   Optional<RoomAmenityDto> findRoomAmenityById(Long roomAmenityId);

  /**
   * Find all room amenities in a room type
   * @param roomtypeId
   * @return List of room amenities
   */
   List<RoomAmenityDto> findAllRoomAmenities(Long roomtypeId);

  /**
   * Update a room amenity
   * @param roomAmenity
   * @return Updated room amenity
   */
   RoomAmenityDto updateRoomAmenity(RoomAmenityDto roomAmenity);

  /**
   * Delete a room amenity
   * @param roomAmenityId
   * @return
   */
  void deleteRoomAmenityById(Long roomAmenityId);
}
