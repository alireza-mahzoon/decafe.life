package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomDto;
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
  private final BeanMapper beanMapper;

  public DefaultRoomService(RoomRepository roomRepository, BeanMapper beanMapper) {
    this.roomRepository = roomRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public RoomDto createRoom(RoomDto room) {
    LOGGER.debug("Create a new room");
    Room roomCreated = roomRepository.save(beanMapper.map(room));
    return beanMapper.map(roomCreated);
  }

  @Override
  public RoomDto updateRoom(RoomDto room) {
    LOGGER.debug("Update a room");
    Room roomUpdated = roomRepository.save(beanMapper.map(room));
    return beanMapper.map(roomUpdated);
  }

  @Override
  public List<Room> findAllRooms(Long hotelId) {
    LOGGER.debug("Find all rooms for the hotel with Id={}", hotelId);
    return roomRepository.findAllByHotelId(hotelId);
  }

  @Override
  public Optional<RoomDto> findRoomById(Long roomId) {
    LOGGER.debug("Find room with id={}", roomId);
    return roomRepository.findById(roomId).map(beanMapper::map);
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
