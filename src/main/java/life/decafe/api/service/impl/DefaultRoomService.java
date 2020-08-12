package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.RoomDto;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.repository.RoomRepository;
import life.decafe.api.repository.RoomTypeRepository;
import life.decafe.api.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DefaultRoomService implements RoomService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomService.class);
  private final RoomRepository roomRepository;
  private final BeanMapper beanMapper;
  private final HotelRepository hotelRepository;
  private final RoomTypeRepository roomTypeRepository;

  public DefaultRoomService(RoomRepository roomRepository, BeanMapper beanMapper, HotelRepository hotelRepository, RoomTypeRepository roomTypeRepository) {
    this.roomRepository = roomRepository;
    this.beanMapper = beanMapper;
    this.hotelRepository = hotelRepository;
    this.roomTypeRepository = roomTypeRepository;
  }

  @Override
  public RoomDto createRoom(RoomDto room) {
    LOGGER.debug("Create a new room");
    room.setId(null);
    room.setRegistered(LocalDateTime.now());
    room.setUpdated(room.getRegistered());
    if (!hotelRepository.existsById(room.getHotelId())) {
      throw new NotFoundException("The hotel is not existed");
    }
    if (!roomTypeRepository.existsById(room.getRoomTypeId())) {
      throw new NotFoundException("The room type is not existed");
    }
    Optional<Room> existedRoom = roomRepository.findByHotelIdAndNumber(room.getHotelId(), room.getNumber());
    if (existedRoom.isPresent()) {
      throw new ResourceConflictException("This room already exists");
    }
    if (!roomTypeRepository.existsByIdAndHotelId(room.getRoomTypeId(), room.getHotelId())) {
      throw new NotFoundException("The room type is not existed");
    }
    Room roomCreated = roomRepository.save(beanMapper.map(room));
    return beanMapper.map(roomCreated);
  }

  public RoomDto updateRoom1(RoomDto room) {
    LOGGER.debug("Update a room");
    Room roomUpdated = new Room();
    Room roomReallyExisted;
    Optional<Room> existedRoom = roomRepository.findById(room.getId());
    if (!existedRoom.isPresent()) {
      throw new NotFoundException("The room does not existed");
    }
    roomReallyExisted = existedRoom.get();
    roomUpdated.setId(roomReallyExisted.getId());
    roomUpdated.setHotelId(roomReallyExisted.getHotelId());
    roomUpdated.setNumber(roomReallyExisted .getNumber());
    roomUpdated.setFloor(roomReallyExisted .getFloor());
    roomUpdated.setRegistered(roomReallyExisted .getRegistered());
    roomUpdated.setUpdated(LocalDateTime.now());
    if (roomReallyExisted.getPhoneNumber().equals(room.getPhoneNumber()) && roomReallyExisted.getRoomTypeId().equals(room.getRoomTypeId())) {
      throw new BadRequestException("The information is not updated");
    }
    if (!roomTypeRepository.existsById(room.getRoomTypeId())) {
      throw new NotFoundException("The room type does not existed");
    }
    roomUpdated.setRoomTypeId(room.getRoomTypeId());
    roomUpdated.setPhoneNumber(room.getPhoneNumber());

    //roomUpdated = roomRepository.save(beanMapper.map(room));
    return beanMapper.map(roomUpdated);
  }

  @Override
  public RoomDto updateRoom(RoomDto roomDto) {
    LOGGER.debug("Updating room with roomId={}", roomDto.getId());
    Room currentRoom = roomRepository.findById(roomDto.getId()).orElseThrow(() -> new NotFoundException("Room does not exist"));
    Room toUpdate = beanMapper.map(roomDto);
    if (!currentRoom.getHotelId().equals(toUpdate.getHotelId())) {
      throw new BadRequestException("Hotel Id cannot be changed");
    }
    if (!toUpdate.getNumber().equals(currentRoom.getNumber())) {
      Optional<Room> existedRoom = roomRepository.findByHotelIdAndNumber(toUpdate.getHotelId(), toUpdate.getNumber());
      if (existedRoom.isPresent()) {
        throw new ResourceConflictException("This room already exists");
      }
    }
    if (!roomTypeRepository.existsByIdAndHotelId(toUpdate.getRoomTypeId(), toUpdate.getHotelId())) {
      throw new NotFoundException("The room type is not existed");
    }
    currentRoom.setNumber(toUpdate.getNumber());
    currentRoom.setPhoneNumber(toUpdate.getPhoneNumber());
    currentRoom.setFloor(toUpdate.getFloor());
    currentRoom.setRoomTypeId(toUpdate.getRoomTypeId());
    currentRoom.setUpdated(LocalDateTime.now());
    return beanMapper.map(roomRepository.save(currentRoom));
  }

  @Override
  public List<RoomDto> findAllRooms(Long hotelId) {
    LOGGER.debug("Find all rooms for the hotel with Id={}", hotelId);
    List<Room> rooms = roomRepository.findAllByHotelId(hotelId);
    List<RoomDto> roomDtos = new ArrayList<>();
    for (Room room: rooms) {
      roomDtos.add(beanMapper.map(room));
    }
    return roomDtos;
  }

  @Override
  public Optional<RoomDto> findRoomById(Long roomId) {
    LOGGER.debug("Find room with id={}", roomId);
    return roomRepository.findById(roomId).map(beanMapper::map);
  }

  @Override
  public void deleteRoom(Long roomId) {
    LOGGER.debug("Delete a room by id={}", roomId);
    Optional<Room> roomToBeDeleted = roomRepository.findById(roomId);
    if (roomToBeDeleted.isPresent()) {
      roomRepository.deleteById(roomId);
    } else {
      throw new NotFoundException("The room does not exist");
    }
  }

  @Override
  public Long countRooms() {
    LOGGER.debug("Count number of rooms");
    return roomRepository.count();
  }
}
