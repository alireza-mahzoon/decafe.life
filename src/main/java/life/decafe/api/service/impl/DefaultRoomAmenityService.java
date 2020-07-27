package life.decafe.api.service.impl;

import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.repository.RoomAmenityRepository;
import life.decafe.api.service.RoomAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultRoomAmenityService implements RoomAmenityService {

  private final Logger LOGGER = LoggerFactory.getLogger(DefaultRoomAmenityService.class);
  private final RoomAmenityRepository roomAmenityRepository;

  public DefaultRoomAmenityService(RoomAmenityRepository roomAmenityRepository) {
    this.roomAmenityRepository = roomAmenityRepository;
  }

  @Override
  public RoomAmenity createRoomAmenity(RoomAmenity roomAmenity) {
    LOGGER.debug("Create a room amenity");
    return roomAmenityRepository.save(roomAmenity);
  }

  @Override
  public Optional<RoomAmenity> findRoomAmenityById(Long roomAmenityId) {
    LOGGER.debug("Find room amenity by Id={}", roomAmenityId);
    return roomAmenityRepository.findById(roomAmenityId);
  }

  @Override
  public List<RoomAmenity> findAllRoomAmenities(Long roomtypeId) {
    LOGGER.debug("Find all room amenities in a room type with Id={}", roomtypeId);
    return roomAmenityRepository.findAllByRoomTypeId(roomtypeId);
  }
}
