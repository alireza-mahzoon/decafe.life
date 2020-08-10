package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.RoomType;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomTypeDto;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultRoomTypeService implements RoomTypeService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomTypeService.class);
  private final RoomTypeRepository roomTypeRepository;
  private final HotelRepository hotelRepository;
  private final BeanMapper beanMapper;

  @Autowired
  public DefaultRoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository, BeanMapper beanMapper) {
    this.roomTypeRepository = roomTypeRepository;
    this.hotelRepository = hotelRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public RoomTypeDto createRoomType(RoomTypeDto roomType) {
    LOGGER.debug("Create a room type");
    roomType.setId(null);
    roomType.setRegistered(LocalDateTime.now());
    roomType.setUpdated(roomType.getRegistered());
    if (!hotelRepository.existsById(roomType.getHotelId())) {
      throw new NotFoundException("The hotel Id is not existed");
    }
    Optional<RoomType> existedRoomType = roomTypeRepository.findByHotelIdAndName(roomType.getHotelId(), roomType.getName());
    if (existedRoomType.isPresent()) {
      throw new ResourceConflictException("RoomType already exists");
    }
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
  public RoomTypeDto updateRoomType(RoomTypeDto roomTypeDto) {
    LOGGER.debug("Update a room type");
    RoomType currentRoomType = roomTypeRepository.findById(roomTypeDto.getId()).orElseThrow(()-> new NotFoundException("Room type does not exist"));
    RoomType toUpdate = beanMapper.map(roomTypeDto);
    if (!currentRoomType.getHotelId().equals(toUpdate.getHotelId())) {
      throw new BadRequestException("Hotel Id cannot be changed");
    }
    if (!toUpdate.getName().equals(currentRoomType.getName())) {
      Optional<RoomType> existedRoomType = roomTypeRepository.findByHotelIdAndName(roomTypeDto.getHotelId(), roomTypeDto.getName());
      if (existedRoomType.isPresent()) {
      throw new ResourceConflictException("This room type is already exists");
      }
    }
    currentRoomType.setName(toUpdate.getName());
    currentRoomType.setDescription(toUpdate.getDescription());
    currentRoomType.setCapacity(toUpdate.getCapacity());
    currentRoomType.setUpdated(LocalDateTime.now());
    return beanMapper.map(roomTypeRepository.save(currentRoomType));
  }

  @Override
  public void deleteRoomType(Long roomTypeId) {
    LOGGER.debug("Delete a room type by Id={}", roomTypeId);
    Optional<RoomType> roomTypeToDelete = roomTypeRepository.findById(roomTypeId);
    if (roomTypeToDelete.isPresent()) {
      roomTypeRepository.deleteById(roomTypeId);
    } else {
      throw new NotFoundException("The room type does not exist");
    }
  }

  @Override
  public Long countRoomTypes() {
    LOGGER.debug("Count number of room types");
    return roomTypeRepository.count();
  }
}
