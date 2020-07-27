package life.decafe.api.service.impl;

import life.decafe.api.model.entity.RoomType;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoomTypeService implements RoomTypeService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomService.class);
  private final RoomTypeRepository roomTypeRepository;

  public DefaultRoomTypeService(RoomTypeRepository roomTypeRepository) {
    this.roomTypeRepository = roomTypeRepository;
  }

  @Override
  public RoomType createRoomType(RoomType roomType) {
    LOGGER.debug("Create a room type");
    return roomTypeRepository.save(roomType);
  }
}
