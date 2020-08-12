package life.decafe.api.service;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.RoomDto;

import java.util.List;
import java.util.Optional;

public interface RoomService {
  /**
   * Create a new room
   * @param room
   * @return newly created room
   */
  RoomDto createRoom(RoomDto room);

  /**
   * Update a room
   * @param room
   * @return updated room
   */
  RoomDto updateRoom(RoomDto room);

  /**
   * Find all rooms of a hotel
   * @param hotelId
   * @return list of rooms
   */
  List<RoomDto> findAllRooms(Long hotelId);

  /**
   * Find room by its Id
   * @param roomId
   * @return room if exists, empty optional otherwise
   */
  Optional<RoomDto> findRoomById(Long roomId);

  /**
   * Delete a room
   * @param roomId
   * @return
   */
  void deleteRoom(Long roomId);

  /**
   * Count number of rooms
   * @param
   * @return number of rooms
   */
  Long countRooms();
}
