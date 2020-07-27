package life.decafe.api.service;

import life.decafe.api.model.entity.Room;

import java.util.List;
import java.util.Optional;

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

  /**
   * Find all rooms of a hotel
   * @param hotelId
   * @return list of rooms
   */
  List<Room> findAllRooms(Long hotelId);

  /**
   * Find room by its Id
   * @param roomId
   * @return room if exists, empty optional otherwise
   */
  Optional<Room> findRoomById(Long roomId);

  /**
   * Delete a room
   * @param roomId
   * @return
   */
  Void deleteRoom(Long roomId);
}
