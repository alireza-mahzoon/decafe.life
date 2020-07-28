package life.decafe.api.service.impl;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.repository.HotelAmenityRepository;
import life.decafe.api.service.HotelAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultHotelAmenityService implements HotelAmenityService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelAmenityService.class);
  private final HotelAmenityRepository hotelAmenityRepository;

  @Autowired
  public DefaultHotelAmenityService(HotelAmenityRepository hotelAmenityRepository) {
    this.hotelAmenityRepository = hotelAmenityRepository;
  }

  @Override
  public HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity) {
    LOGGER.debug("Create a hotel amenity");
    hotelAmenityRepository.save(hotelAmenity);
    return hotelAmenityRepository.save(hotelAmenity);
  }
}
