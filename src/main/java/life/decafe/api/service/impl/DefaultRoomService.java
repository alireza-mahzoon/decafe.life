package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Room;
import life.decafe.api.repository.RoomRepository;
import life.decafe.api.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
}
