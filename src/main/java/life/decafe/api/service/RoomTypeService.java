package life.decafe.api.service;

import life.decafe.api.model.entity.RoomType;

public interface RoomTypeService {

  /**
   * Create a new roomType
   * @param roomType
   * @return newly created roomType
   */
  RoomType createRoomType(RoomType roomType);
}
