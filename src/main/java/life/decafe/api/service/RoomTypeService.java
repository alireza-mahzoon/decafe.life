package life.decafe.api.service;

import life.decafe.api.model.entity.RoomType;
import life.decafe.api.model.rest.RoomTypeDto;

import java.util.List;
import java.util.Optional;

public interface RoomTypeService {

  /**
   * Create a new roomType
   * @param roomType
   * @return newly created roomType
   */
  RoomType createRoomType(RoomType roomType);

  /**
   * Find a room type by its Id
   * @param roomTypeId
   * @return room type if exists, empty optional otherwise
   */
  Optional<RoomTypeDto> findRoomTypeById(Long roomTypeId);

  /**
   * Find all room types for a hotel Id
   * @param hotelId
   * @return list of room types that exist in a hotel
   */
  List<RoomTypeDto> findAllRoomTypes(Long hotelId);

  /**
   * Update a room type
   * @param roomType
   * @return Updated room type
   */
  RoomType updateRoomType(RoomType roomType);

  /**
   * Delete a room type
   * @param roomTypeId
   * @return
   */
  Void deleteRoomType(Long roomTypeId);

  /**
   * Count number of all room types
   * @param
   * @return number of room types
   */
  Long countRoomTypes();
}
