package life.decafe.api.service.impl;

import life.decafe.api.model.entity.RoomType;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomTypeDto;
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
  private final BeanMapper beanMapper;

  @Autowired
  public DefaultRoomTypeService(RoomTypeRepository roomTypeRepository, BeanMapper beanMapper) {
    this.roomTypeRepository = roomTypeRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public RoomType createRoomType(RoomType roomType) {
    LOGGER.debug("Create a room type");
    return roomTypeRepository.save(roomType);
  }

  @Override
  public Optional<RoomTypeDto> findRoomTypeById(Long roomTypeId) {
    LOGGER.debug("Find a room type by its id={}", roomTypeId);
    return roomTypeRepository.findById(roomTypeId).map(beanMapper::map);
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

  @Override
  public Long countRoomTypes() {
    LOGGER.debug("Count number of room types");
    return roomTypeRepository.count();
  }
}
