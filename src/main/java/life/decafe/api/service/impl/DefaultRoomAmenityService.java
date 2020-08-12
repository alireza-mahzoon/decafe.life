package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomAmenityDto;
import life.decafe.api.repository.RoomAmenityRepository;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultRoomAmenityService implements RoomAmenityService {

  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomAmenityService.class);
  private final RoomAmenityRepository roomAmenityRepository;
  private final RoomTypeRepository roomTypeRepository;
  private final BeanMapper beanMapper;

  public DefaultRoomAmenityService(RoomAmenityRepository roomAmenityRepository, RoomTypeRepository roomTypeRepository, BeanMapper beanMapper) {
    this.roomAmenityRepository = roomAmenityRepository;
    this.roomTypeRepository = roomTypeRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public RoomAmenityDto createRoomAmenity(RoomAmenityDto roomAmenity) {
    LOGGER.debug("Create a room amenity");
    roomAmenity.setId(null);
    roomAmenity.setRegistered(LocalDateTime.now());
    roomAmenity.setUpdated(roomAmenity.getRegistered());
    if (!roomTypeRepository.existsById(roomAmenity.getRoomTypeId())) {
      throw new NotFoundException("The room type is not existed");
    }
    Optional<RoomAmenity> existedRoomAmenity = roomAmenityRepository.findByRoomTypeIdAndName(roomAmenity.getRoomTypeId(), roomAmenity.getName());
    if (existedRoomAmenity.isPresent()) {
      throw new ResourceConflictException("The room amenity already exists");
    }
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
  public RoomAmenityDto updateRoomAmenity(RoomAmenityDto roomAmenityDto) {
    LOGGER.debug("Update a room amenity");
    RoomAmenity currentRoomAmenity = roomAmenityRepository.findById(roomAmenityDto.getId()).orElseThrow(() -> new NotFoundException("Room Amenity does not exist"));
    RoomAmenity toUpdate = beanMapper.map(roomAmenityDto);
    if (!currentRoomAmenity.getRoomTypeId().equals(toUpdate.getRoomTypeId())) {
      throw new BadRequestException("Room type Id cannot be changed");
    }
    if (!toUpdate.getName().equals(currentRoomAmenity.getName())) {
      Optional<RoomAmenity> existedRoomAmenity = roomAmenityRepository.findByRoomTypeIdAndName(toUpdate.getRoomTypeId(), toUpdate.getName());
      if (existedRoomAmenity.isPresent()) {
        throw new ResourceConflictException("The room amenity already existed");
      }
    }
    currentRoomAmenity.setName(toUpdate.getName());
    currentRoomAmenity.setDescription(toUpdate.getDescription());
    currentRoomAmenity.setPricing(toUpdate.getPricing());
    currentRoomAmenity.setUpdated(LocalDateTime.now());
    return beanMapper.map(roomAmenityRepository.save(currentRoomAmenity));
  }

  @Override
  public void deleteRoomAmenityById(Long roomAmenityId) {
    LOGGER.debug("Delete a room amenity by Id={}", roomAmenityId);
    Optional<RoomAmenity> roomToDelete = roomAmenityRepository.findById(roomAmenityId);
    if (roomToDelete.isPresent()) {
      roomAmenityRepository.deleteById(roomAmenityId);
    } else {
      throw new NotFoundException("The room amenity does not exist");
    }
  }
}
