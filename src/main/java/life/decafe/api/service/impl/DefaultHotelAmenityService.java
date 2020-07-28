package life.decafe.api.service.impl;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.repository.HotelAmenityRepository;
import life.decafe.api.service.HotelAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultHotelAmenityService implements HotelAmenityService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelAmenityService.class);
  private final HotelAmenityRepository hotelAmenityRepository;

  public DefaultHotelAmenityService(HotelAmenityRepository hotelAmenityRepository) {
    this.hotelAmenityRepository = hotelAmenityRepository;
  }

  @Override
  public HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity) {
    LOGGER.debug("Create a hotel amenity");
    hotelAmenityRepository.save(hotelAmenity);
    return hotelAmenityRepository.save(hotelAmenity);
  }

  @Override
  public Optional<HotelAmenity> findHotelAmenityById(Long hotelAmenityId) {
    LOGGER.debug("Find a hotel amenity by Id={}", hotelAmenityId);
    return hotelAmenityRepository.findById(hotelAmenityId);
  }

  @Override
  public HotelAmenity updateHotelAmenity(HotelAmenity hotelAmenity) {
    LOGGER.debug("Update hotel amenity");
    return hotelAmenityRepository.save(hotelAmenity);
  }
}
