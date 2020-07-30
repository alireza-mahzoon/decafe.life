package life.decafe.api.service.impl;

import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomAmenityDto;
import life.decafe.api.repository.RoomAmenityRepository;
import life.decafe.api.service.RoomAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultRoomAmenityService implements RoomAmenityService {

  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomAmenityService.class);
  private final RoomAmenityRepository roomAmenityRepository;
  private final BeanMapper beanMapper;

  public DefaultRoomAmenityService(RoomAmenityRepository roomAmenityRepository, BeanMapper beanMapper) {
    this.roomAmenityRepository = roomAmenityRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public RoomAmenityDto createRoomAmenity(RoomAmenityDto roomAmenity) {
    LOGGER.debug("Create a room amenity");
    RoomAmenity roomAmenityCreated = roomAmenityRepository.save(beanMapper.map(roomAmenity));
    return beanMapper.map(roomAmenityCreated);
  }

  @Override
  public Optional<RoomAmenityDto> findRoomAmenityById(Long roomAmenityId) {
    LOGGER.debug("Find room amenity by Id={}", roomAmenityId);
    return roomAmenityRepository.findById(roomAmenityId).map(beanMapper::map);
  }

  @Override
  public List<RoomAmenityDto> findAllRoomAmenities(Long roomtypeId) {
    LOGGER.debug("Find all room amenities in a room type with Id={}", roomtypeId);
    List<RoomAmenity> roomAmenities = roomAmenityRepository.findAllByRoomTypeId(roomtypeId);
    return roomAmenities.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public RoomAmenityDto updateRoomAmenity(RoomAmenityDto roomAmenity) {
    LOGGER.debug("Update a room amenity");
    RoomAmenity roomAmenityUpdated = roomAmenityRepository.save(beanMapper.map(roomAmenity));
    return beanMapper.map(roomAmenityUpdated);
  }

  @Override
  public Void deleteRoomAmenityById(Long roomAmenityId) {
    LOGGER.debug("Delete a room amenity by Id={}", roomAmenityId);
    roomAmenityRepository.deleteById(roomAmenityId);
    return null;
  }
}
