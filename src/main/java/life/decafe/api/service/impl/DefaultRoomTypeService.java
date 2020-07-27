package life.decafe.api.service.impl;

import life.decafe.api.model.entity.RoomType;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultRoomTypeService implements RoomTypeService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomTypeService.class);
  private final RoomTypeRepository roomTypeRepository;

  @Autowired
  public DefaultRoomTypeService(RoomTypeRepository roomTypeRepository) {
    this.roomTypeRepository = roomTypeRepository;
  }

  @Override
  public RoomType createRoomType(RoomType roomType) {
    LOGGER.debug("Create a room type");
    return roomTypeRepository.save(roomType);
  }

  @Override
  public Optional<RoomType> findRoomTypeById(Long roomTypeId) {
    LOGGER.debug("Find a room type by its id={}", roomTypeId);
    return roomTypeRepository.findById(roomTypeId);
  }

  @Override
  public List<RoomType> findAllRoomTypes(Long hotelId) {
    LOGGER.debug("Find all room types for hotel with Id={}", hotelId);
    return  roomTypeRepository.findAllByHotelId(hotelId);
  }

  @Override
  public RoomType updateRoomType(RoomType roomType) {
    LOGGER.debug("Update a room type");
    return roomTypeRepository.save(roomType);
  }

  @Override
  public Void deleteRoomType(Long roomTypeId) {
    LOGGER.debug("Delete a room type by Id={}", roomTypeId);
    roomTypeRepository.deleteById(roomTypeId);
    return null;
  }
}
