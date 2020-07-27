package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Room;
import life.decafe.api.repository.RoomRepository;
import life.decafe.api.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultRoomService implements RoomService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomService.class);
  private final RoomRepository roomRepository;

  public DefaultRoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @Override
  public Room createRoom(Room room) {
    LOGGER.debug("Create a new room");
    return roomRepository.save(room);
  }

  @Override
  public Room updateRoom(Room room) {
    LOGGER.debug("Update a room");
    return roomRepository.save(room);
  }

  @Override
  public List<Room> findAllRooms(Long hotelId) {
    LOGGER.debug("Find all rooms for the hotel with Id={}", hotelId);
    return roomRepository.findAllByHotelId(hotelId);
  }

  @Override
  public Optional<Room> findRoomById(Long roomId) {
    LOGGER.debug("Find room with id={}", roomId);
    return roomRepository.findById(roomId);
  }

  @Override
  public Void deleteRoom(Long roomId) {
    LOGGER.debug("Delete a room by id={}", roomId);
    roomRepository.deleteById(roomId);
    return null;
  }

  @Override
  public Long countRooms() {
    LOGGER.debug("Count number of rooms");
    return roomRepository.count();
  }
}
