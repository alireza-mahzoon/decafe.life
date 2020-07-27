package life.decafe.api.service;

import life.decafe.api.model.entity.RoomType;

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
  Optional<RoomType> findRoomTypeById(Long roomTypeId);
}
