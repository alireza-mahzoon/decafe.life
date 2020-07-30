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
import java.util.stream.Collectors;

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
  public RoomTypeDto createRoomType(RoomTypeDto roomType) {
    LOGGER.debug("Create a room type");
    RoomType roomTypeCreated = roomTypeRepository.save(beanMapper.map(roomType));
    return beanMapper.map(roomTypeCreated);
  }

  @Override
  public Optional<RoomTypeDto> findRoomTypeById(Long roomTypeId) {
    LOGGER.debug("Find a room type by its id={}", roomTypeId);
    return roomTypeRepository.findById(roomTypeId).map(beanMapper::map);
  }

  @Override
  public List<RoomTypeDto> findAllRoomTypes(Long hotelId) {
    LOGGER.debug("Find all room types for hotel with Id={}", hotelId);
    List<RoomType> roomTypeList = roomTypeRepository.findAllByHotelId(hotelId);
    return roomTypeList.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public RoomTypeDto updateRoomType(RoomTypeDto roomType) {
    LOGGER.debug("Update a room type");
    RoomType roomTypeUpdated = roomTypeRepository.save(beanMapper.map(roomType));
    return beanMapper.map(roomTypeUpdated);
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
