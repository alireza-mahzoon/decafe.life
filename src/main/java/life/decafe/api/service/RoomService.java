package life.decafe.api.service;

import life.decafe.api.model.entity.Room;

public interface RoomService {
  /**
   * Create a new room
   * @param room
   * @return newly created room
   */
  Room createRoom(Room room);

  /**
   * Update a room
   * @param room
   * @return updated room
   */
  Room updateRoom(Room room);
}
