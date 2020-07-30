package life.decafe.api.service.impl;

import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelAmenityDto;
import life.decafe.api.repository.HotelAmenityRepository;
import life.decafe.api.service.HotelAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultHotelAmenityService implements HotelAmenityService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelAmenityService.class);
  private final HotelAmenityRepository hotelAmenityRepository;
  private final BeanMapper beanMapper;

  public DefaultHotelAmenityService(HotelAmenityRepository hotelAmenityRepository, BeanMapper beanMapper) {
    this.hotelAmenityRepository = hotelAmenityRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public HotelAmenity createHotelAmenity(HotelAmenity hotelAmenity) {
    LOGGER.debug("Create a hotel amenity");
    hotelAmenityRepository.save(hotelAmenity);
    return hotelAmenityRepository.save(hotelAmenity);
  }

  @Override
  public Optional<HotelAmenityDto> findHotelAmenityById(Long hotelAmenityId) {
    LOGGER.debug("Find a hotel amenity by Id={}", hotelAmenityId);
    return hotelAmenityRepository.findById(hotelAmenityId).map(beanMapper::map);
  }

  @Override
  public HotelAmenity updateHotelAmenity(HotelAmenity hotelAmenity) {
    LOGGER.debug("Update hotel amenity");
    return hotelAmenityRepository.save(hotelAmenity);
  }

  @Override
  public List<HotelAmenity> findAllHotelAmenities(Long hotelId) {
    LOGGER.debug("find all hotel amenities with hotel Id={}", hotelId);
    return hotelAmenityRepository.findAllByHotelId(hotelId);
  }

  @Override
  public Void deleteHotelAmenityById(Long hotelAmenityId) {
    LOGGER.debug("Delete hotel amenity with Id={}", hotelAmenityId);
    hotelAmenityRepository.deleteById(hotelAmenityId);
    return null;
  }
}
